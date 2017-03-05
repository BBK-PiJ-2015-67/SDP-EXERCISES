package abstractfactory

/**
  * @author lmignot
  */
case class LondonFeedback() extends XMLParser {
  override def parse(s: String): String = "LondonFEEDBACK: " + s.map(c => (c + 2).toChar)
}