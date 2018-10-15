package garage

/**
  * Bike object inherits vehicle and contain bike parts
  *
  * @author Nelvin
  * @param regNo    registration number
  * @param customer the customer which owns the vehicle
  */
class Bike(regNo: String, customer: Customer) extends Vehicle(regNo, "bike", false, 0) {
  private val bikeParts = Array(new Part(regNo, "Handle", false, 9.99),
    new Part(regNo, "Tire", false, 9.99), new Part(regNo, "Air filter", false, 9.99),
    new Part(regNo, "Brake", false, 14.99), new Part(regNo, "Battery", false, 9.99),
    new Part(regNo, "Engine", false, 19.99), new Part(regNo, "Spark Plug", false, 9.99),
    new Part(regNo, "Seat", false, 4.99), new Part(regNo, "Chain", false, 6.99),
    new Part(regNo, "Gear", false, 12.99))

  override def toString: String = f"Bike reg no. $regNo. Fixed $fixed. Total cost £$bill%.2f\nCustomer: ${customer.toString}\n"

  override def viewPart(regNo: String): Unit = {
    bikeParts.foreach(x => if (x.regNo == regNo & x.broken == true) println(x.toString))
  }

  override def breakParts(): Unit = {
    val brokenPartIndex = scala.collection.mutable.ArrayBuffer.empty[Int]
    for (i <- 0 until 4) bikeParts(scala.util.Random.nextInt((9 - 0) + 1)).broken = true
    bikeParts.foreach(value => println(value.toString))
  }

  breakParts()

}
