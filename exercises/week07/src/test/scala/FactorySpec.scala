import factory._
import test.BaseSpec

/**
  * @author lmignot
  */
class FactorySpec extends BaseSpec {

  describe("A Product Factory") {

    it("should create a default Product") {
      Given("A product factory")
      When("getInstance is called without parameters")
      val p: Product = ConcreteCreator()

      Then("A default product should be returned")
      p shouldBe a [ConcreteProduct]

      And("It should have a default name")
      p.name should be ("Default")

      And("It should have the default cost")
      p.cost should be (0.0)
    }

    it("should create the correct Product") {
      Given("A product factory")
      When("a Toy is requested")
      val toy: Product = ConcreteCreator("toy")

      Then("A Toy should be created")
      toy shouldBe a [Toy]

      When("Food is requested")
      val pasta: Product = ConcreteCreator("food")

      Then("Food should be created")
      pasta shouldBe a [Food]

      When("a Tool is requested")
      val wrench: Product = ConcreteCreator("tool")

      Then("a Tool should be created")
      wrench shouldBe a [Tool]
    }
  }
}
