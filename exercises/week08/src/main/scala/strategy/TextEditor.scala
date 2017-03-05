package strategy

case class TextEditor(f: String => String) {
  def publishText(s: String):String = f(s)
}
