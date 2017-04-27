package chain

case class AudioFileHandler(s: String) extends
  FileHandler(s, Vector("audio", "mp3", "wav")) {}

object AudioFileHandler {
  def apply(s: String, handler: Handler): Handler =
    AudioFileHandler(s).setHandler(handler)
}
