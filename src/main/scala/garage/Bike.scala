package garage

/**
  * Bike object inherits vehicle and contain bike parts
  *
  * @author Nelvin
  * @param regNo    registration number
  * @param customer the customer which owns the vehicle
  */
class Bike(regNo: String, customer: Customer) extends Vehicle(regNo, "bike", false, 0) {
  //  def this(regNo: String, customer: Customer) = this(regNo, 0, customer)
  private val bikeParts = Array(new Part(regNo, "Handle", false, 0),
    new Part(regNo, "Tire", false, 0), new Part(regNo, "Air filter", false, 0),
    new Part(regNo, "Brake", false, 0), new Part(regNo, "Battery", false, 0),
    new Part(regNo, "Engine", false, 0), new Part(regNo, "Spark Plug", false, 0),
    new Part(regNo, "Seat", false, 0), new Part(regNo, "Chain", false, 0),
    new Part(regNo, "Gear", false, 0))

  override def toString: String = f"Bike reg no. $regNo. Fixed $fixed. Total cost £$bill%.2f\nCustomer: ${customer.toString}\n"

  override def viewPart(regNo: String): Array[Any] = {
    bikeParts.map(x => if (x.regNo == regNo) Array(x))
  }
}
