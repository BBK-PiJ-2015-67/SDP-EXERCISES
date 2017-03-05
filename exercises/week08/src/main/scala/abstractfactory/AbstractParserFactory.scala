package abstractfactory

/**
  * @author lmignot
  */
trait AbstractParserFactory {
  def getParserInstance(parserType: String): Option[XMLParser]
}
