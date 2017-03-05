package abstractfactory

/**
  * @author lmignot
  */

object NYCFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): Option[XMLParser] = parserType match {
    case "NYCORDER" => Some(NycOrder())
    case _ => None
  }
}
