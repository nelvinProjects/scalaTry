/**
  * Fibonacci using method recursion
  *
  * @author Nelvin
  */
object Fibonacci {
  def main(args: Array[String]): Unit = {
    fibonacci(10)
    fibonacci2(0)
    fibonacci2(1)
    fibonacci2(2)
    fibonacci2(3)
    fibonacci2(4)
    fibonacci2(5)
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

  /**
    * Print fibonacci at given value
    *
    * @param valueNeeded how many fibonacci to until
    * @param i           the current fibonacci at current
    * @param previous    last fibonacci
    */
  def fibonacci2(valueNeeded: Int, i: Int = 0, previous: Int = 1): Unit = valueNeeded match {
    case value if valueNeeded == 0 => println(i)
    case _ => fibonacci2(valueNeeded - 1, i + previous, i)
  }
}
