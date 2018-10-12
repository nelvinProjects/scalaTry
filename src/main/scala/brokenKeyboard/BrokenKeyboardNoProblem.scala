package brokenKeyboard

import scala.io.Source
import scala.util.control.Breaks._

object BrokenKeyboardNoProblem {
  private val userInput = collection.mutable.ArrayBuffer[String]()

  def main(args: Array[String]): Unit = {
    val wordForMatching = readTxT()
    getUserInput()
    userInput.foreach(value => println(value + " = " + matchInputWithWords(wordForMatching, value)))
  }

  def readTxT(): Array[String] = {
    Source.fromFile("C:\\Users\\Admin\\IdeaProjects\\scalaTry\\src\\main\\scala\\brokenKeyboard\\words.txt").getLines.toArray
  }

  def getUserInput(): Unit = {
    println("Enter how many lines to read")
    var lines = io.StdIn.readInt()

    breakable {
      while (true) {
        if (lines == 0) break
        println("Enter line of working letters")
        userInput += io.StdIn.readLine()
        lines = lines - 1
      }
    }
  }

  def matchInputWithWords(words: Array[String], keyboard: String): String = {
    val wordsFound = collection.mutable.ArrayBuffer[String]()
    for (word <- words) {
      val wordChar = word.toSet
      val keyboardChar = keyboard.toSet
      if (keyboardChar subsetOf (wordChar)) {
        val remaining = (wordChar -- keyboardChar).size
        if (remaining == 0) wordsFound += word
      }
      if (wordChar subsetOf (keyboardChar)) {
        val left = (wordChar -- keyboardChar).size
        if (left == 0) wordsFound += word
      }
    }

    //    wordsFound.foreach(println)
    //    println()
    //    wordsFound.map(s => {if(s.length % 2 == 0) s.sortWith(_ < _) else s.sortWith(_ > _)}).foreach(println)
    //    wordsFound.sortWith(_.length > _.length).foreach(println)

    wordsFound.length > 0 match {
      case true => wordsFound.sortWith(_.length > _.length).head
      case _ => "None Found"
    }
  }

}
