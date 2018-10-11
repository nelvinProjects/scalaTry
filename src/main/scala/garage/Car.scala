package garage

/**
  * Car object inherit vehicle
  *
  * @author Nelvin
  * @param regNo    registration number
  * @param customer the customer who owns the vehicle
  */
class Car(regNo: String, customer: Customer) extends Vehicle(regNo, "car", false, 0) {

  override def toString: String = f"Car reg no. $regNo. Fixed: $fixed. Total cost £$bill%.2f\nCustomer: ${customer.toString}\n"
}
