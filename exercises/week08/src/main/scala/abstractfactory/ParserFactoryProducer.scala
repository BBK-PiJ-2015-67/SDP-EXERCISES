package abstractfactory

/**
  * @author lmignot
  */
object ParserFactoryProducer {
  def getFactory(s: String): Option[AbstractParserFactory] = s match {
    case "NYCFactory" => Some(NYCFactory)
    case "LondonFactory" => Some(LondonFactory)
    case _ => None
  }
}
