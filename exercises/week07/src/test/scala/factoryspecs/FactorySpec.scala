package factoryspecs
import test._
import factory._

/**
  * @author lmignot
  */
class FactorySpec extends BaseSpec {

  describe("A Factory") {
    describe("A default Factory") {
      it("should return a default Product") {
        val creator: Creator = new ConcreteCreator
        val p: Product = creator.factory("")

        p shouldBe a [DefaultProduct]
        p.getName should be ("Default")
        p.getCost should be (0.0)
      }
    }

    it("should return the correct Product") {
      val creator: Creator = new ConcreteCreator
      val toy: Product = creator.factory("toy")
      val pasta: Product = creator.factory("food")
      val wrench: Product = creator.factory("tool")

      toy shouldBe a [Toy]
      pasta shouldBe a [Food]
      wrench shouldBe a [Tool]
    }
  }
}
