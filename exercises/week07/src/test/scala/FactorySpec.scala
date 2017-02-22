import factory._
import test._

/**
  * @author lmignot
  */
class FactorySpec extends BaseSpec {

  describe("A Factory") {
    it("should return a default Product") {
      val creator: Creator = new ConcreteCreator
      val p: Product = creator.getInstance()

      p shouldBe a [DefaultProduct]
      p.getName should be ("Default")
      p.getCost should be (0.0)
    }

    it("should return the correct Product") {
      val creator: Creator = new ConcreteCreator
      val toy: Product = creator.getInstance("toy")
      val pasta: Product = creator.getInstance("food")
      val wrench: Product = creator.getInstance("tool")

      toy shouldBe a [Toy]
      pasta shouldBe a [Food]
      wrench shouldBe a [Tool]
    }
  }
}
