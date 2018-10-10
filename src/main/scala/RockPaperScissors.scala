import util.control.Breaks._

object RockPaperScissors {
  var playerMoves = collection.mutable.ArrayBuffer[Int]()
  var playerScore: Int = _
  var cpuScore: Int = _

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
    println(s"Final score- Player: $playerScore       CPU: $cpuScore")
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
    userMove match {
      case userMove if (userMove == cpuMove) => "Tie"
      case userMove if (userMove == 1 & cpuMove == 2) => {
        cpuScore += 100
        s"CPU wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 1 & cpuMove != 2) => {
        playerScore += 100
        s"User wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 2 & cpuMove == 3) => {
        cpuScore += 100
        s"CPU wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 2 & cpuMove != 3) => {
        playerScore += 100
        s"User wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 3 & cpuMove == 1) => {
        cpuScore += 100
        s"CPU wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 3 & cpuMove != 1) => {
        playerScore += 100
        s"User wins! : User chose ${convertChosen(userMove)} v CPU chose ${convertChosen(cpuMove)}"
      }
      case _ => "Invalid move"
    }
  }

  def cpuMove(): Int = {
    if (playerMoves.length < 3) {
      val cpuFinal = scala.util.Random.nextInt((4 - 1) + 1)
      if (cpuFinal > 0 & cpuFinal < 4) {
        println("randomise " + cpuFinal);
        cpuFinal
      }
      else 2
    } else {
      playerMoves.max match {
        case 1 => {
          println("player defeat " + 2);
          2
        }
        case 2 => {
          println("player defeat " + 3);
          3
        }
        case 3 => {
          println("player defeat " + 1);
          1
        }
      }
    }
  }
}
