package garage

object Main {
  def main(args: Array[String]): Unit = {
    val garage = new Garage
    garage.openGarage()
    garage.addVehicle("JK09",
      "car", "James", "Thompson", 27)
    garage.addVehicle("JK19",
      "car", "Tim", "Vin", 32)
    garage.addVehicle("WN09",
      "car", "John", "Bt", 19)
    garage.addVehicle("TK08",
      "bike", "Tina", "May", 26)
    garage.addVehicle("LO12",
      "bike", "April", "June", 24)

    println(garage.allVehicles())

    garage.registeringEmployees("David", "Jobs", 35)
    garage.registeringEmployees("Robin", "Bills", 35)

    println(garage.allEmployees())

    garage.vehicleToFix("TK08")
    garage.vehicleToFix("LO12")

    garage.vehicleFixed("TK08")
    garage.vehicleFixed("jk09")

    garage.calculateBills()

    println(garage.allVehicles())

    garage.closeGarage()
  }
}
