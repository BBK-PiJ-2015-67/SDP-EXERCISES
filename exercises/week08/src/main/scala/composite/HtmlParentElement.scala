package composite

case class HtmlParentElement(tagName: String) extends HtmlTag(tagName) {
  var startTag: String = _
  var endTag: String = _
  var tagBody: String = _

  private var children: List[HtmlTag] = List()

  override def generateHtml: String = {
    if (children.nonEmpty) {
      s"$startTag" + children.foldLeft("\n")((a, b) => a + b.generateHtml) + s"\n$endTag"
    } else {
      s"$startTag$endTag"
    }
  }

  override def setStartTag(tag: String): Unit = startTag = tag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def setTagBody(body: String): Unit = tagBody = body

  override def addChildTag(htmlTag: HtmlTag): Unit = children :+= htmlTag

  override def removeChildTag(htmlTag: HtmlTag): Unit = children = children.filter(_ != htmlTag)

  override def getChildren: List[HtmlTag] = children
}
