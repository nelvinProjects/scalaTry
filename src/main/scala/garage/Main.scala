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
    garage.addVehicle("YI34",
      "car", "Kade", "Gomez", 19)
    garage.addVehicle("POI8",
      "car", "Georgiana", "Moffett", 19)
    garage.addVehicle("SDR45",
      "car", "Shaunna", "Kulick", 19)
    garage.addVehicle("BTYU32",
      "car", "Germaine", "Cavallo", 19)
    garage.addVehicle("SDFR32",
      "car", "Shea", "Arenas", 19)
    garage.addVehicle("TK08",
      "bike", "Tina", "May", 26)
    garage.addVehicle("LO12",
      "bike", "April", "June", 24)
    garage.addVehicle("GTY54",
      "bike", "Rosa", "Brautigam", 24)
    garage.addVehicle("POU43",
      "bike", "Jasmine", "Arnette", 24)
    garage.addVehicle("VBU34",
      "bike", "Sean", "Bond", 24)
    garage.addVehicle("BGR43",
      "bike", "Kylie", "Intel", 24)

    println(garage.allVehicles())

    garage.registeringEmployees("David", "Jobs", 35)
    garage.registeringEmployees("Robin", "Bills", 35)
    garage.registeringEmployees("Louis", "Bezos", 35)

    println(garage.allEmployees())

    garage.brokenParts("TK08")

    garage.fixVehicle()

    garage.closeGarage()
  }
}
