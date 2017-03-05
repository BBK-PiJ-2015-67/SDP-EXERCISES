package strategy

/**
  * Since scala supports HOF, there doesn't seem to be a need
  * for the conventional strategy pattern implementation.
  *
  * Examples provided below
  */
object TestStrategyPattern extends App {
  def ucFormat(s:String): String = s.toUpperCase
  def lcFormat(s:String): String = s.toLowerCase
  var editor: TextEditor = TextEditor(ucFormat)
  println(editor.publishText("Testing text in caps formatter"))
  editor = TextEditor(_.toUpperCase)
  println(editor.publishText("Testing text in caps formatter"))
  editor = TextEditor(lcFormat)
  println(editor.publishText("Testing text in lower formatter"))
  editor = TextEditor(_.toLowerCase)
  println(editor.publishText("Testing text in lower formatter"))
}
