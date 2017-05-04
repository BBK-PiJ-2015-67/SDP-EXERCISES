package visitor

case class HtmlParentElement(var tagName: String) extends HtmlTag {
  var startTag: String = ""
  var endTag: String = ""

  private var childrenTag = List[HtmlTag]()

  def getTagName: String = tagName

  def getEndTag: String = endTag

  def setEndTag(tag: String): Unit = endTag = tag

  def getStartTag: String = startTag

  def setStartTag(tag: String): Unit = startTag = tag

  override def addChildTag(htmlTag: HtmlTag): Unit = childrenTag :+= htmlTag

  override def removeChildTag(htmlTag: HtmlTag): Unit = childrenTag = childrenTag.filter(_ != htmlTag)

  override def getChildren: List[HtmlTag] = childrenTag

  override def accept(visitor: Visitor): Unit = visitor.visit(this)

  override def generateHtml(): Unit = {
    println(startTag)
    if (childrenTag.nonEmpty) {
      childrenTag.foreach(_.generateHtml())
    }
    println(endTag)
  }
}
