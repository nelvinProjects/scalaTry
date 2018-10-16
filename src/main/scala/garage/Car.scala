package garage

/**
  * Car object inherit vehicle and contain car parts
  *
  * @author Nelvin
  * @param regNo    registration number
  * @param customer the customer who owns the vehicle
  */
class Car(regNo: String, customer: Customer) extends Vehicle(regNo, "car", false, 0) {
  private val carParts = Array(new Part(regNo, 1, "Steering wheel", false, 9.99, 20),
    new Part(regNo, 2, "Tire", false, 9.99, 10), new Part(regNo, 3, "Air filter", false, 9.99, 10),
    new Part(regNo, 4, "Brake", false, 14.99, 45), new Part(regNo, 5, "Battery", false, 9.99, 10),
    new Part(regNo, 6, "Engine", false, 19.99, 60), new Part(regNo, 7, "Spark Plug", false, 9.99, 10),
    new Part(regNo, 8, "Seat", false, 4.99, 15), new Part(regNo, 9, "Headlight", false, 6.99, 20),
    new Part(regNo, 10, "Gear", false, 12.99, 30))

  override def toString: String = f"Car reg no. $regNo. Fixed: $fixed. Total cost £$bill%.2f\nCustomer: ${customer.toString}\n"

  override def viewPart(regNp: String): Array[Part] = {
    carParts.filter(x => (x.regNo == regNo & x.broken == true))
  }

  override def breakParts(): Unit = {
    for (i <- 0 until 4) carParts(scala.util.Random.nextInt((9 - 0) + 1)).broken = true
    carParts.foreach(value => println(value.toString))
  }

  breakParts()

  override def fixPart(regNo: String, partID: Int): Unit = {
    carParts.map(x => if (x.regNo == regNo & x.partID == partID) x.broken = false)
  }
}
