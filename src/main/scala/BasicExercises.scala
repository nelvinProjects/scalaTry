import java.util.TimeZone

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

    //Swap values
    println(swapValues(Array(1, 2, "Hey"))) //Passing array of integers
    println(swapValues(List(1, 2, "End"))) //Passing list of integers
    val tupleValue = Tuple3(1, 3, 5)
    println(swapValues(tupleValue)) //Passing tuple of integers

    //TimeZone IDs
    println(getTimeZoneIds().mkString(", "))

    //BlackJack
    println(blackJack(0, 21))
    println(blackJack(21, 0))
    println(blackJack(5, 18))
    println(blackJack(19, 5))
    println(blackJack(-5, 5))
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
    valueOne match {
      case valueOne if (valueOne == 0 & valueTwo == 0) => 0
      case valueOne if (valueOne == 0) => valueTwo
      case valueOne if (valueTwo == 0) => valueOne
      case valueOne if (add) => {
        valueOne + valueTwo
      }
      case valueOne if (!add) => {
        valueOne * valueTwo
      }
    }
    //
    //    if (valueOne == 0 & valueTwo == 0) 0
    //    if (valueOne == 0) valueTwo
    //    if (valueTwo == 0) valueOne
    //    if (add) {
    //      valueOne + valueTwo
    //    } else {
    //      valueOne * valueTwo
    //    }
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
    if (i > 0) {
      i match {
        case i if (i % 3 == 0 & i % 5 == 0) => println(wordForThree + wordForFive)
        case i if (i % 3 == 0) => println(wordForThree)
        case i if (i % 5 == 0) => println(wordForFive)
        case _ => println(i)
      }
      fizzBuzz(wordForThree, wordForFive, i - 1)
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

  /**
    * Takes pair of int and returns the value swapped
    *
    * @param valueOne the first int value
    * @param valueTwo the second int value
    * @return the swapped values
    */
  def swapValues(valueOne: Any): String = {
    valueOne match {
      case valueOne: Array[Any] => valueOne.reverse.mkString(", ")
      case valueOne: List[Any] => valueOne.reverse.mkString(", ")
      case valueOne if (valueOne.isInstanceOf[Product]) => Array(valueOne).mkString(", ").reverse.replace(")", "").replace("(", "")
      case _ => "Invalid data"
    }
  }

  /**
    * Timezones array
    *
    * @return array containing timezones
    */
  def getTimeZoneIds(): Array[String] = {
    TimeZone.getAvailableIDs.map(value => value.split("/")).filter(_.length == 2)
      .grouped(10).map(value => value(0)(1)).toArray
    //     .foreach(elem => println(elem(0)(1)))
  }

  /**
    * Blackjack: Return the value closest to 21 without going over 21. If they both do
    * return 0.
    *
    * @param valueOne the first value
    * @param valueTwo the second value
    * @return the value closest to 21 or 0
    */
  def blackJack(valueOne: Int, valueTwo: Int): Int = {
    if (valueOne <= 0 & valueTwo <= 0) 0
    else if (valueOne > 21 & valueTwo > 21) 0
    else if (valueOne <= 21 & (valueOne > valueTwo || valueTwo > 21)) valueOne
    else if (valueTwo <= 21 & (valueTwo > valueOne || valueOne > 21)) valueTwo
    else -1
  }

  /**
    * Unique Sum: Return sum of 3 inputs which are unique
    *
    * @param one   the first value
    * @param two   the second value
    * @param third the third value
    * @return sum value of input parameters
    */
  def uniqueSum(one: Int, two: Int, third: Int): Int = {
    0
  }

}
