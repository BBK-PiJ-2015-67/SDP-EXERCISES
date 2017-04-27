package chain

case class ImageFileHandler(s: String) extends
  FileHandler(s, Vector("jpg", "png", "gif", "webp")) {}

object ImageFileHandler {
  def apply(s: String, handler: Handler): Handler =
    ImageFileHandler(s).setHandler(handler)
}
