package garage

/**
  * Vehicle abstract class
  *
  * @param regNo       registration number
  * @param vehicleType type of vehicle
  * @param fixed       vehicle fixed
  * @param bill        the cost of vehicle repair
  */
abstract class Vehicle(val regNo: String, val vehicleType: String, var fixed: Boolean, var bill: Double) {
  def viewPart(regNp: String): Array[Any]
}
