package composite

case class HtmlElement(tagName: String) extends HtmlTag(tagName) {
  var startTag: String = _
  var endTag: String = _
  var tagBody: String = _

  override def setStartTag(tag: String): Unit = startTag = tag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def setTagBody(body: String): Unit = tagBody = body

  override def generateHtml: String = s"$startTag$tagBody$endTag"
}
