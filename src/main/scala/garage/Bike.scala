package garage

/**
  * Bike object inherits vehicle
  *
  * @author Nelvin
  * @param regNo    registration number
  * @param customer the customer which owns the vehicle
  */
class Bike(regNo: String, customer: Customer) extends Vehicle(regNo, "bike", false, 0) {
  //  def this(regNo: String, customer: Customer) = this(regNo, 0, customer)

  override def toString: String = f"Bike reg no. $regNo. Fixed $fixed. Total cost £$bill%.2f\nCustomer: ${customer.toString}\n"
}
