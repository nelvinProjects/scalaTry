package garage

/**
  * Car object inherit vehicle and contain car parts
  *
  * @author Nelvin
  * @param regNo    registration number
  * @param customer the customer who owns the vehicle
  */
class Car(regNo: String, customer: Customer) extends Vehicle(regNo, "car", false, 0) {
  private val carParts = Array(new Part(regNo, "Steering wheel", false, 9.99),
    new Part(regNo, "Tire", false, 9.99), new Part(regNo, "Air filter", false, 9.99),
    new Part(regNo, "Brake", false, 14.99), new Part(regNo, "Battery", false, 9.99),
    new Part(regNo, "Engine", false, 19.99), new Part(regNo, "Spark Plug", false, 9.99),
    new Part(regNo, "Seat", false, 4.99), new Part(regNo, "Headlight", false, 6.99),
    new Part(regNo, "Gear", false, 12.99))

  override def toString: String = f"Car reg no. $regNo. Fixed: $fixed. Total cost £$bill%.2f\nCustomer: ${customer.toString}\n"

  override def viewPart(regNp: String): Array[Any] = {
    carParts.map(x => if (x.regNo == regNo) Array(x))
  }
}
