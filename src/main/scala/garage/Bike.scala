package garage

/**
  * Bike object inherits vehicle and contain bike parts
  *
  * @author Nelvin
  * @param regNo    registration number
  * @param customer the customer which owns the vehicle
  */
class Bike(regNo: String, customer: Customer) extends Vehicle(regNo, "bike", false, 0) {
  private val bikeParts = Array(new Part(regNo, 1, "Handle", false, 9.99, 30),
    new Part(regNo, 2, "Tire", false, 9.99, 20), new Part(regNo, 3, "Air filter", false, 9.99, 20),
    new Part(regNo, 4, "Brake", false, 14.99, 45), new Part(regNo, 5, "Battery", false, 9.99, 10),
    new Part(regNo, 6, "Engine", false, 19.99, 60), new Part(regNo, 7, "Spark Plug", false, 9.99, 15),
    new Part(regNo, 8, "Seat", false, 4.99, 15), new Part(regNo, 9, "Chain", false, 6.99, 45),
    new Part(regNo, 10, "Gear", false, 12.99, 30))

  override def toString: String = f"Bike reg no. $regNo. Fixed $fixed. Total cost £$bill%.2f\nCustomer: ${customer.toString}\n"

  override def viewPart(regNo: String): Array[Part] = {
    bikeParts.filter(x => (x.regNo == regNo & x.broken == true))
  }

  override def breakParts(): Unit = {
    for (i <- 0 until 4) bikeParts(scala.util.Random.nextInt((9 - 0) + 1)).broken = true
  }

  breakParts()

  override def fixPart(regNo: String, partID: Int): Unit = {
    bikeParts.map(x => if (x.regNo == regNo & x.partID == partID) x.broken = false)
  }
}
