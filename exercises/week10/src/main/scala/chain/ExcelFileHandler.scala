package chain

case class ExcelFileHandler(s: String) extends
  FileHandler(s, Vector("xls", "xlsx", "csv")) {}

object ExcelFileHandler {
  def apply(s: String, handler: Handler): Handler =
    ExcelFileHandler(s).setHandler(handler)
}
