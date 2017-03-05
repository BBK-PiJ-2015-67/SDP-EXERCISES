package abstractfactory

object TestAbstractFactoryPattern extends App {
  val originalMessage = "Parse this XML data using the correct factory."

  val nycParser = ParserFactoryProducer.getFactory("NYCFactory")
    .flatMap(_.getParserInstance("NYCORDER"))
  val nycMessage = nycParser.map(_.parse(originalMessage))
  println(nycMessage)

  println("*"*40)

  val londonParser = ParserFactoryProducer.getFactory("LondonFactory")
    .flatMap(_.getParserInstance("LondonFEEDBACK"))
  val londonMessage = londonParser.map(_.parse(originalMessage))
  println(londonMessage)
}