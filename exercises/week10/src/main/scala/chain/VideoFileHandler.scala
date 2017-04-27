package chain

case class VideoFileHandler(s: String) extends
  FileHandler(s, Vector("video", "mp4", "mpg", "mkv", "mov", "m4v")) {}

object VideoFileHandler {
  def apply(s: String, handler: Handler): Handler =
    VideoFileHandler(s).setHandler(handler)
}

