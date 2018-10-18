import scala.io.Source
import util.control.Breaks._

object Advanced {
  def main(args: Array[String]): Unit = {
    primeNumbers1()
  }

  def readFile(): Array[String] = {
    Source.fromFile("/Users/").getLines.toArray
  }

  def anagrams(value: String) = {

  }

  def primeNumbers1(): Unit = {
    var counter = 0

    breakable {
      var i = 1
      while (true) {
        if (i == 3000000) break()
        if (i % 2 > 0 && i % 7 > 0 && i % 3 > 0 && i % 5 > 0) {
          counter += 1
          //          println(i)
        }
        i += 1
      }
    }
    println(s"There are $counter prime numbers between 1 to 3,000,000")
  }
}
