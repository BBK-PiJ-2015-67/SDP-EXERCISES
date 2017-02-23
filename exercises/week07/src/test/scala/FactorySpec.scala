import factory._
import test.BaseSpec

/**
  * @author lmignot
  */
class FactorySpec extends BaseSpec {

  describe("A Product Factory") {

    it("should create a default Product") {
      Given("A product factory")
      val creator: Creator = new ConcreteCreator

      When("getInstance is called without parameters")
      val p: Product = creator.create()

      Then("A default product should be returned")
      p shouldBe a [ConcreteProduct]

      And("It should have a default name")
      p.getName should be ("Default")

      And("It should have the default cost")
      p.getCost should be (0.0)
    }

    it("should create the correct Product") {
      Given("A product factory")
      val creator: Creator = new ConcreteCreator

      When("a Toy is requested")
      val toy: Product = creator.create("toy")

      Then("A Toy should be created")
      toy shouldBe a [Toy]

      When("Food is requested")
      val pasta: Product = creator.create("food")

      Then("Food should be created")
      pasta shouldBe a [Food]

      When("a Tool is requested")
      val wrench: Product = creator.create("tool")

      Then("a Tool should be created")
      wrench shouldBe a [Tool]
    }
  }
}
