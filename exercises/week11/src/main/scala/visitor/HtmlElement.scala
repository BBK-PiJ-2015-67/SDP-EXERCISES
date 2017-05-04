package visitor

case class HtmlElement(var tagName: String) extends HtmlTag {
  private var startTag: String = ""
  private var endTag: String = ""
  private var tagBody: String = ""

  override def getTagName: String = tagName

  override def getEndTag: String = endTag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def getStartTag: String = startTag

  override def setStartTag(tag: String): Unit = startTag = tag

  override def setTagBody(tagBody: String): Unit = this.tagBody = tagBody

  override def accept(visitor: Visitor): Unit = visitor.visit(this)

  override def generateHtml(): Unit = println(s"$startTag$tagBody$endTag")

}
