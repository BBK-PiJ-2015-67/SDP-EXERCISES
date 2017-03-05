package abstractfactory

/**
  * @author lmignot
  */
object LondonFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): Option[XMLParser] = parserType match {
    case "LondonFEEDBACK" => Some(LondonFeedback())
    case _ => None
  }
}
