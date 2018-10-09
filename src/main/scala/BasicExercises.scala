/**
  * Basic Scala Exercises
  *
  * @author Nelvin
  */

object BasicExercises {

  def main(args: Array[String]): Unit = {
    //print Hello World
    println("Hello World!")

    //Store hello world and print it
    val helloWorld = "Hello World!"
    println(helloWorld)

    //print function
    printString("Print function")

    //Return string function
    println(inputString("Hello World!"))

    //No return, passing Double
    typeInference(12.05)
    //No return, passing String
    typeInference("Scala EX")
    //No return, passing Integer
    typeInference(5)
    //No return, passing Boolean
    typeInference(false)

    //The end value of word
    println(endOfString("Hello", 3))

    //Replace character
    replaceCharInString("Hal", "lo", 'a', 'e')
    replaceCharInString("Biil", "ean", 'i', 'o')

    //Sum-Multiply
    println(sum(5, 4, true))
    println(sum(5, 4, false))
    println(sum(0, 4, false))
    println(sum(5, 0, false))
    println(sum(0, 0, true))

    //Print word iterator
    printWordIterator("Scala is here", 4)

    //Print word in square
    wordSquare("T", 5)

    //FizzBuzz
    fizzBuzz("Fizz", "Buzz", 15)
  }

  /**
    * Print input function
    *
    * @param value
    */
  def printString(value: String): Unit = {
    println(value)
  }

  /**
    * Return input string
    *
    * @param value String value to return
    * @return the input string
    */
  def inputString(value: String): String = {
    value
  }

  /**
    * No return type given and outputs the input
    *
    * @param value Any data type input for print
    */
  def typeInference(value: Any) = {
    println(s"Value is $value and type is ${value.getClass}")
  }

  /**
    * Return end characters of specified word depending on the int given
    *
    * @param word     The word to edit
    * @param noOfChar The number of characters of word
    *                 to be returned
    */
  def endOfString(word: String, noOfChar: Int): String = {
    word.takeRight(noOfChar)
  }

  /**
    * Join two words and replace all occurrences of a character
    *
    * @param wordOne     First word
    * @param wordTwo     Second word
    * @param replaceChar replace character in word
    * @param newChar     character to be replaced with
    */
  def replaceCharInString(wordOne: String, wordTwo: String, replaceChar: Char, newChar: Char): Unit = {
    println(wordOne.replace(replaceChar, newChar) + wordTwo.replace(replaceChar, newChar))
  }

  /**
    * Sum of two int values if true else return multiply result
    *
    * @param valueOne first int value
    * @param valueTwo second int value
    * @param add      true to sum or false to multiply
    */
  def sum(valueOne: Int, valueTwo: Int, add: Boolean): Int = {
    if (valueOne == 0 & valueTwo == 0) 0
    if (valueOne == 0) valueTwo
    if (valueTwo == 0) valueOne
    if (add) {
      valueOne + valueTwo
    } else {
      valueOne * valueTwo
    }
  }

  /**
    * Print out given string as many times as given int value
    *
    * @param word      the value to be printed
    * @param noOfTimes number of times to be printed
    */
  def printWordIterator(word: String, noOfTimes: Int): Unit = {
    for (i <- 0 until noOfTimes) {
      println(word)
    }
  }

  /**
    * Print word in square format
    *
    * @param word         The value to be printed
    * @param squareLength length of square
    */
  def wordSquare(word: String, squareLength: Int): Unit = {
    for (i <- 0 until squareLength) {
      for (j <- 0 until squareLength) {
        print(word)
      }
      println()
    }
  }

  /**
    * FizzBuzz-Print string if divisible by 3 or 5
    *
    * @param wordForThree word to output if divisible by 3
    * @param wordForFive  word to output if divisible by 5
    * @param loopUntil    final loop value
    */
  def fizzBuzz(wordForThree: String, wordForFive: String, loopUntil: Int): Unit = {
    val i: Int = loopUntil
    i match {
      case i if (i % 3 == 0 & i % 5 == 0) => println(wordForThree + wordForFive)
      case i if (i % 3 == 0) => println(wordForThree)
      case i if (i % 5 == 0) => println(wordForFive)
      case _ => println(i)
      case 0 => fizzBuzz(wordForThree, wordForFive, i - 1)
    }

    //    if (i > 0) {
    //      if (i % 3 == 0 & i % 5 == 0) println(wordForThree + wordForFive)
    //      else if (i % 3 == 0) println(wordForThree)
    //      else if (i % 5 == 0) println(wordForFive)
    //      else println(i)
    //
    //      fizzBuzz(wordForThree, wordForFive, i - 1)
    //    }
  }
}
