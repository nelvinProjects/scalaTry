package brokenKeyboard

import scala.io.Source

/**
  * Takes string input from user and returns the largest word possible
  * to be created using the input.
  */
object BrokenKeyboardNoProblem {
  private val userInput = collection.mutable.ArrayBuffer[String]()

  def main(args: Array[String]): Unit = {
    val wordForMatching = readTxT()
    getUserInput()
    userInput.foreach(value => println(value + " = " + matchInputWithWords(wordForMatching, value)))
  }

  /**
    * Read text file containing words to use
    *
    * @return array containing words
    */
  def readTxT(): Array[String] = {
    Source.fromFile("..\\scalaTry\\src\\main\\scala\\brokenKeyboard\\words.txt").getLines.toArray
  }

  /**
    * Ask for how many lines the user wish to enter (int) and get the string values
    */
  def getUserInput(): Unit = {
    println("Enter how many lines to read")
    val lines = io.StdIn.readInt()

    for (i <- 0 until lines) {
      println("Enter line of working letters")
      userInput += io.StdIn.readLine()
    }
  }

  /**
    * Takes each input and compare with array containing all the words and return the longest word
    *
    * @param words    the array containing all the words
    * @param keyboard the user input
    * @return the longest word
    */
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

    wordsFound.nonEmpty match {
      case true => wordsFound.sortWith(_.length > _.length).head
      case _ => "None Found"
    }
  }

}
