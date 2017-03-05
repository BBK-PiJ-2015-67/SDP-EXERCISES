import abstractfactory._
import test.BaseSpec

/**
  * AbstractFactory tests
  * @author lmignot
  */
class AbstractFactorySpec extends BaseSpec {
  describe("An abstract factory") {
    it("abstract factory should return the appropriate factory if available") {
      val opt: Option[AbstractParserFactory] = ParserFactoryProducer.getFactory("NYCFactory")
      opt.get shouldBe a [AbstractParserFactory]
      opt.isDefined should be (true)
    }

    it("abstract factory should return None if no factory is available") {
      val opt: Option[AbstractParserFactory] = ParserFactoryProducer.getFactory("asdf")
      opt shouldBe None
      opt.isEmpty should be (true)
    }

    it("if a factory is available, factory should return parser if available") {
      val msg = "Parse this XML data using the correct factory."
      val expected = "LondonFEEDBACK: Rctug\"vjku\"ZON\"fcvc\"wukpi\"vjg\"eqttgev\"hcevqt{0"
      val opt: Option[XMLParser] = ParserFactoryProducer
        .getFactory("LondonFactory")
        .flatMap(_.getParserInstance("LondonFEEDBACK"))
      opt.get shouldBe a [XMLParser]
      opt.isDefined should be (true)
      opt.get.parse(msg) should be (expected)
    }

    it("if a factory is available, factory should return None if no parser is available") {
      val opt: Option[XMLParser] = ParserFactoryProducer
        .getFactory("LondonFactory")
        .flatMap(_.getParserInstance("NYCORDER"))
      opt shouldBe None
      opt.isDefined should be (false)
    }

    it("if no factory is available, and no parser is available should return None") {
      val opt: Option[XMLParser] = ParserFactoryProducer
        .getFactory("asdf")
        .flatMap(_.getParserInstance("NYCORDER"))
      opt shouldBe None
      opt.isDefined should be (false)
    }

  }
}