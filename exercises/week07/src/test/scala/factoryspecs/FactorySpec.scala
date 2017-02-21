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
  }
}
