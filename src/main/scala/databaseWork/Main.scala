package databaseWork

import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

/**
  * For references: http://books.underscore.io/essential-slick/essential-slick-3.html
  * Database connection and CRUD
  */

object Main {
  def main(args: Array[String]): Unit = {
    dropDB
    Thread.sleep(1000)
    searchPerson("cat")
    howManyPeople
    averageAge
    groupFirstName
    groupLastName
    db.close()
  }

  val db = Database.forConfig("mysqlDB")
  val peopleTable = TableQuery[People]
  val dropPeopleCmd = DBIO.seq(peopleTable.schema.drop)
  val initPeopleCmd = DBIO.seq(peopleTable.schema.create)

  def dropDB = {
    //do a drop followed by initialisePeople
    val dropFuture = Future {
      db.run(dropPeopleCmd)
    }
    //Attempt to drop the table, Await does not block here
    Await.result(dropFuture, Duration.Inf).andThen {
      case Success(_) => initialisePeople
      case Failure(error) => println("Dropping the table failed due to: " + error.getMessage)
        initialisePeople
    }
  }

  def initialisePeople = {
    //initialise people
    val setupFuture = Future {
      db.run(initPeopleCmd)
    }

    Await.result(setupFuture, Duration.Inf).andThen {
      case Success(_) => runQuery
      case Failure(error) =>
        println("Initialising the table failed due to: " + error.getMessage)
    }
  }

  def runQuery = {
    val insertPeople = Future {
      val query = peopleTable ++= Seq(
        (0, "Jack", "Wood", 36), (0, "Tim", "Brown", 24),
        (0, "James", "Gray", 23), (0, "Cat", "Bat", 30),
        (0, "Tina", "Jones", 28), (0, "Tina", "Bean", 25),
        (0, "Nim", "Brown", 23)
      )
      println(query.statements.head)
      db.run(query)
    }

    Await.result(insertPeople, Duration.Inf).andThen {
      case Success(_) => listPeople
        updatePerson
      case Failure(error) =>
        println("Welp! Something went wrong! " + error.getMessage)
    }
  }

  def listPeople = {
    val queryFuture = Future {
      db.run(peopleTable.result).map(_.foreach {
        case (id, fName, lName, age) => println(s" $id $fName $lName $age")
      })
    }

    Await.result(queryFuture, Duration.Inf).andThen {
      case Failure(error) => println("Listing people failed due to: " + error.getMessage)
    }
  }

  def updatePerson = {
    val update = Future {
      db.run(peopleTable.filter(_.fName === "Tim")
        .map(p => (p.lName, p.age))
        .update(("Bond", 30)))
    }
    println()
    Await.result(update, Duration.Inf).andThen {
      case Success(_) => listPeople
        deletePerson
      case Failure(exception) => println("Failed to update " + exception.getMessage)
    }
  }

  def deletePerson = {
    val delete = Future {
      db.run(peopleTable.filter(p => p.id === 3).delete)
    }
    println("Delete person")
    Await.result(delete, Duration.Inf).andThen {
      case Success(_) => listPeople
      case Failure(exception) => println("Failed to delete " + exception.getMessage)
    }
  }

  def searchPerson(firstName: String) = {
    val find = peopleTable.filter(p => p.fName === firstName).result

    println(s"Searching for $firstName")
    Await.result(db.run(find).map {
      println
    }, Duration.Inf)
  }

  def howManyPeople = {
    val totalPeople = peopleTable.length.result
    print("Total number of people in table36 ")
    Await.result(db.run(totalPeople).map {
      println
    }, Duration.Inf)
  }

  def averageAge = {
    val average = db.run(peopleTable.map(_.age).avg.result)
    print("Average age ")
    Await.result(average.map(println), Duration.Inf)
  }

  def groupFirstName = {
    val nameCommon = db.run(peopleTable.groupBy(_.fName).map {
      case (fName, age) => fName
    }.result).map(println)
    println("Common first name")
    Await.result(nameCommon, Duration.Inf)
  }

  def groupLastName = {
    val nameCommon = db.run(peopleTable.groupBy(_.lName).map {
      case (lName, age) => lName
    }.result).map(println)
    println("Common Last name")
    Await.result(nameCommon, Duration.Inf)
  }
}
