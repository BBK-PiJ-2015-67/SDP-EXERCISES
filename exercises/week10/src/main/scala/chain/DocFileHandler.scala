package chain

case class DocFileHandler(s: String) extends
  FileHandler(s, Vector("doc", "docx", "rtf")) {}

object DocFileHandler {
  def apply(s: String, handler: Handler): Handler =
    DocFileHandler(s).setHandler(handler)
}
