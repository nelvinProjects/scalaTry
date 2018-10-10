import util.control.Breaks._

object RockPaperScissors {
  var playerMoves = collection.mutable.ArrayBuffer[Int]()

  def main(args: Array[String]): Unit = {
    val playOn = true
    println("Welcome, enter how many rounds to play")
    var rounds = io.StdIn.readInt()
    breakable {
      while (playOn) {
        if (rounds == 0) break
        println("Enter your move")
        val userInput = io.StdIn.readLine()
        val moveValue = moveConvert(userInput)
        breakable {
          if (moveValue == 0) {
            break()
          }
          playerMoves += moveValue
          println(playerMoves)
          println(cpuMove())
          println(decision(moveValue, cpuMove()))
          rounds = rounds - 1
        }
      }
    }
  }

  def moveConvert(move: String): Int = {
    move.toLowerCase() match {
      case "rock" => 1
      case "paper" => 2
      case "scissors" => 3
      case _ => 0
    }
  }

  def convertChosen(move: Int): String = {
    move match {
      case 1 => "rock"
      case 2 => "paper"
      case 3 => "scissors"
    }
  }

  def decision(userMove: Int, cpuMove: Int): String = {
    println(s"USERRR $userMove   CPUUU $cpuMove")
    if (userMove == cpuMove) "Tie"
    if (userMove == 1 & cpuMove != 2) {
      s"User wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
    } else {
      println("1 iF state " + cpuMove != 2)
      s"CPU wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
    }
    if (userMove == 2 & cpuMove != 3) {
      s"User wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
    } else {
      println("2 iF state " + cpuMove != 3)
      s"CPU wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
    }
    if (userMove == 3 & cpuMove != 1) {
      s"User wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
    } else {
      println("3 iF state " + cpuMove != 1)
      s"CPU wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
    }
  }

  def cpuMove(): Int = {
    if (playerMoves.length < 2) {
      val cpuFinal = scala.util.Random.nextInt((4 - 1) + 1)
      if (cpuFinal > 0 & cpuFinal < 4) cpuFinal
      else 2
    } else {
      playerMoves.max match {
        case 1 => 2
        case 2 => 3
        case 3 => 1
      }
    }
  }
}
