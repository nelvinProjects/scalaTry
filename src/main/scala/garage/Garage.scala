package garage

/**
  * Garage class: responsible for ->
  * adding vehicle, removing vehicle, registering employees, fixing vehicle
  * calculating bills, output all vehicles, open/close garage
  *
  * @author Nelvin
  */
class Garage {
  /**
    * storeVehicles: Stores all the vehicles using their reg no as key
    * garageEmployees: Store all the employees working at garage
    * garageOpen: Check if garage is open
    */
  private val storeVehicles = scala.collection.mutable.HashMap.empty[String, Vehicle]
  private val garageEmployees = scala.collection.mutable.ListBuffer.empty[Person]
  private var garageOpen = false

  /**
    * Add vehicle to garage (to list)
    *
    * @param regNo             the vehicle registration no. (should be unique)
    * @param vehicleType       type of vehicle
    * @param customerFirstName customer first name
    * @param customerSurname   customer surname
    * @param customerAge       customer age
    */
  def addVehicle(regNo: String, vehicleType: String, customerFirstName: String,
                 customerSurname: String, customerAge: Int): Unit = {
    if (!garageOpen) println("Garage Closed-Not able to do process")
    else
      vehicleType.toLowerCase match {
        case "car" => storeVehicles += (regNo -> new Car(regNo,
          new Customer(customerFirstName, customerSurname, customerAge)))
        case "bike" => storeVehicles += (regNo -> new Bike(regNo,
          new Customer(customerFirstName, customerSurname, customerAge)))
        case _ => None
      }
  }

  /**
    * Return all the vehicles stored in garage (from list)
    *
    * @return all the vehicle information
    */
  def allVehicles(): String = {
    if (!garageOpen) "Garage Closed-Not able to do process"
    else
      storeVehicles.mkString("\n")
  }

  /**
    * Store garage employee to list
    *
    * @param employeeFirstName employee first name
    * @param employeeSurname   employee surname
    * @param employeeAge       employee age
    */
  def registeringEmployees(employeeFirstName: String, employeeSurname: String, employeeAge: Int): Unit = {
    if (!garageOpen) println("Garage Closed-Not able to do process")
    else
      garageEmployees += new Employee(employeeFirstName, employeeSurname, employeeAge)
  }

  /**
    * All the employees working in garage (list)
    *
    * @return all the employee information
    */
  def allEmployees(): String = {
    if (!garageOpen) "Garage Closed-Not able to do process"
    else
      garageEmployees.mkString("\n")
  }

  /**
    * Fix vehicle
    *
    * @param regNo the vehicle to be fixed
    */
  def vehicleToFix(regNo: String): Unit = {
    if (!garageOpen) println("Garage Closed-Not able to do process")
    else {
      println(s"Fixing vehicle ${regNo.toUpperCase}")
      storeVehicles(regNo.toUpperCase).fixed = true
    }
  }

  /**
    * Check if vehicle is fixed
    *
    * @param regNo the vehicle to be checked
    */
  def vehicleFixed(regNo: String): Unit = {
    if (!garageOpen) println("Garage Closed-Not able to do process")
    else {
      regNo match {
        case regNo if (storeVehicles(regNo.toUpperCase).fixed) =>
          println(s"Vehicle ${regNo.toUpperCase} is fixed")
        case _ => println(s"Vehicle ${regNo.toUpperCase} is not fixed")
      }
    }
  }

  /**
    * Add cost to fixed vehicles
    */
  def calculateBills(): Unit = {
    if (!garageOpen) println("Garage Closed-Not able to do process")
    else
      storeVehicles.map(value => if (value._2.fixed) value._2.bill = 20.50)
  }

  /**
    * Open garage: Set garageOpen to true
    */
  def openGarage(): Unit = {
    garageOpen = true
  }

  /**
    * Close garage
    */
  def closeGarage(): Unit = {
    garageOpen = false
  }

  def partAdd(regNo: String): Unit = {

  }
}
