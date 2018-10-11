import util.control.Breaks._

/**
  * Rock, Paper, Scissors Game:
  * Player can choose the rounds to play and there are two modes available:
  * Mode 1: Player V CPU
  * Mode 2: CPU V CPU
  * At the end of the game the final scores will be given
  *
  * @author Nelvin
  */
object RockPaperScissors {
  /**
    * Store the scores and player's previous moves
    */
  var playerScore: Int = _
  var cpuScore: Int = _
  var playerMoves = collection.mutable.ArrayBuffer[Int]()

  def main(args: Array[String]): Unit = {
    println("Welcome, enter how many rounds to play")
    var rounds = io.StdIn.readInt()
    println("Enter mode: 1 -Player V CPU or 2 -CPU V CPU")
    val gameMode = io.StdIn.readInt()

    //CPU V CPU
    if (gameMode == 2) {
      breakable {
        while (true) {
          //Stop game when round finishes
          if (rounds == 0) break

          //Gets CPU move and store in playerMove array
          val firstCPU = cpuMove()
          playerMoves += firstCPU
          println(decision(firstCPU, cpuMove(), "CPU1", "CPU2"))
          rounds = rounds - 1
        }
      }
      //Print final scores
      println(s"Final score- CPU1: $playerScore       CPU2: $cpuScore")
    } else {
      breakable {
        //Player V CPU
        while (true) {
          if (rounds == 0) break
          println("Enter your move")

          //Take player input and convert move to int
          val userInput = io.StdIn.readLine()
          val moveValue = moveConvert(userInput)

          breakable {
            //Go back to main loop if player value given not valid
            if (moveValue == 0) {
              break()
            }
            //Add player move to array for future CPU moves
            playerMoves += moveValue
            println(decision(moveValue, cpuMove(), "User", "CPU"))
            rounds = rounds - 1
          }
        }
      }
      println(s"Final score- Player: $playerScore       CPU: $cpuScore")
    }

  }

  /**
    * Takes player input (rock, paper, scissors) and returns int value associated
    * with the string. If invalid move is given, 0 is returned
    *
    * @param move the player input
    * @return the int value associated with move given
    */
  def moveConvert(move: String): Int = {
    move.toLowerCase() match {
      case "rock" => 1
      case "paper" => 2
      case "scissors" => 3
      case _ => 0
    }
  }

  /**
    * Takes int value associated with rock, paper or scissors and gets the string value back
    *
    * @param move the int value of move
    * @return the string value of move
    */
  def convertChosen(move: Int): String = {
    move match {
      case 1 => "rock"
      case 2 => "paper"
      case 3 => "scissors"
    }
  }

  /**
    * Compares both the player and CPU moves to see who won the round
    *
    * @param userMove the player or cpu move
    * @param cpuMove  the CPU move
    * @param player1  the player/cpu name
    * @param player2  the cpu name
    * @return the string showing who won the round
    */
  def decision(userMove: Int, cpuMove: Int, player1: String, player2: String): String = {
    userMove match {
      case userMove if (userMove == cpuMove) => "Tie"
      case userMove if (userMove == 1 & cpuMove == 2) => {
        cpuScore += 100
        s"$player2 wins! : $player1 chose ${convertChosen(userMove)} v $player2 chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 1 & cpuMove != 2) => {
        playerScore += 100
        s"$player1 wins! : $player1 chose ${convertChosen(userMove)} v $player2 chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 2 & cpuMove == 3) => {
        cpuScore += 100
        s"$player2 wins! : $player1 chose ${convertChosen(userMove)} v $player2 chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 2 & cpuMove != 3) => {
        playerScore += 100
        s"$player1 wins! : $player1 chose ${convertChosen(userMove)} v $player2 chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 3 & cpuMove == 1) => {
        cpuScore += 100
        s"$player2 wins! : $player1 chose ${convertChosen(userMove)} v $player2 chose ${convertChosen(cpuMove)}"
      }
      case userMove if (userMove == 3 & cpuMove != 1) => {
        playerScore += 100
        s"$player1 wins! : $player1 chose ${convertChosen(userMove)} v $player2 chose ${convertChosen(cpuMove)}"
      }
      case _ => "Invalid move"
    }
  }

  /**
    * The cpu moves: first two moves are random and any rounds followed are
    * using previous player moves to get max value and return move which defeats that
    * specific max move
    *
    * @return CPU int move value
    */
  def cpuMove(): Int = {
    if (playerMoves.length < 3) {
      val cpuFinal = scala.util.Random.nextInt((4 - 1) + 1)
      if (cpuFinal > 0 & cpuFinal < 4) {
        cpuFinal
      } else 2
    } else {
      playerMoves.max match {
        case 1 => 2
        case 2 => 3
        case 3 => 1
      }
    }
  }
}
