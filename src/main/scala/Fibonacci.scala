/**
  * Fibonacci using method recursion
  *
  * @author Nelvin
  */
object Fibonacci {
  def main(args: Array[String]): Unit = {
    fibonacci(10)
  }

  /**
    * Print fibonacci series
    *
    * @param nth      how many values to be printed
    * @param i        the next value
    * @param previous the last value
    */
  def fibonacci(nth: Int, i: Int = 0, previous: Int = 0): Unit = i match {
    case i if nth == 0 => 0
    case i if i == 0 => println("0\n1")
      fibonacci(nth - 2, 1, 0)
    case _ => println(i + previous)
      fibonacci(nth - 1, i + previous, i)
  }
}
