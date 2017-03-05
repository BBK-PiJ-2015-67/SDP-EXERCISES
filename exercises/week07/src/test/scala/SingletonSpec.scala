package test
import singleton._

/**
  * @author lmignot
  */
class SingletonSpec extends BaseSpec {
  describe("A Singleton") {

    it("An eager Singleton") {
      Given("An eager Singleton is requested")
      val sg: Singleton = EagerSingleton.getInstance

      When("It is requested again")
      val sg2: Singleton = EagerSingleton.getInstance

      Then("both references should point to the same object")
      sg should be theSameInstanceAs sg2

      And("And both references should have the same id")
      sg.getId should be (sg2.getId)
    }

    it("A lazy Singleton") {
      Given("A lazy Singleton is requested")
      val sg: Singleton = LazySingleton.getInstance

      When("It is requested again")
      val sg2: Singleton = LazySingleton.getInstance

      Then("both references should point to the same object")
      sg should be theSameInstanceAs sg2

      And("And both references should have the same id")
      sg.getId should be (sg2.getId)
    }
  }
}
