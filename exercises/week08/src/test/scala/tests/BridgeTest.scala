package tests

import bridge._

/**
  * @author lmignot
  */
class BridgeTest extends BaseTest {
  private val BigWheelName = "BigWheel xz model"
  private val CentralLockingName = "Central Locking System"
  private val GearLockingName = "Gear Locking System"

  describe("Bridge Pattern") {
    it("should allow a Car to swap in any Product at assembly") {
      Given("a product")
      val product: Product = CentralLocking(CentralLockingName)

      And("a Car")
      var car: Car = BigWheel(product, BigWheelName)

      When("The car produces a product and is assembled")
      Then("The car should adapt the product and be assembled according to the specification")
      car.produceProduct should be (s"Modifying product $CentralLockingName according to $BigWheelName")
      car.assemble should be (s"Assembling $CentralLockingName for $BigWheelName")

      Given("a new product")
      val product2: Product = GearLocking(GearLockingName)

      And("a car provided with this new product")
      car = BigWheel(product2, BigWheelName)

      When("The car produces a product and is assembled")
      Then("The car should adapt the product and be assembled according to the new specification")
      car.produceProduct should be (s"Modifying product $GearLockingName according to $BigWheelName")
      car.assemble should be (s"Assembling $GearLockingName for $BigWheelName")
    }
  }
}
