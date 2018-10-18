import garage.Garage
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen


class GarageTests extends FeatureSpec with GivenWhenThen {
  feature("Garage open/close") {
    scenario("Not able to garage process without garage being open") {
      Given("Garage is closed")
      val garage = new Garage
      assertResult(garage.allVehicles()) {
        "Garage Closed-Not able to do process"
      }

      When("Garage is open")

      Then("Adding vehicle")
      garage.addVehicle("LO12",
        "bike", "April", "June", 24)
      assertResult(garage.allVehicles().length) {
        36
      }

      And("Close the garage")
      garage.closeGarage()
      assertResult(garage.allVehicles()) {
        "Garage Closed-Not able to do process"
      }

    }
  }
  feature("Fix vehicles") {
    scenario("Customers add vehicles and majority get fixed") {
    }
  }
}
