package garage

/**
  * Customer of vehicle
  *
  * @author Nelvin
  * @param firstName  takes firstname
  * @param secondName takes surname
  * @param age        age of person
  */
class Customer(firstName: String, secondName: String, age: Int)
  extends Person(firstName, secondName, age) {

  override def toString: String = s"Name: $firstName $secondName, age: $age"
}
