package abstractfactory

/**
  * @author lmignot
  */
case class NycOrder() extends XMLParser {
  override def parse(s: String): String = "NYCORDER: " + s.map(c => (c + 1).toChar)
}