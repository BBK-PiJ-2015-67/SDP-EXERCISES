package chain

case class TextFileHandler(s: String) extends
  FileHandler(s, Vector("txt", "bat", "md")) {}

object TextFileHandler {
  def apply(s: String, handler: Handler): Handler =
    TextFileHandler(s).setHandler(handler)
}
