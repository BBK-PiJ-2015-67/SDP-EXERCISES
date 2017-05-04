package visitor

abstract class HtmlTag extends Element {
  def getTagName: String
  def setStartTag(tag: String): Unit
  def getStartTag: String
  def setEndTag(tag: String): Unit
  def getEndTag: String
  def setTagBody(tagBody: String): Unit = ???
  def addChildTag(htmlTag: HtmlTag): Unit = ???
  def removeChildTag(htmlTag: HtmlTag): Unit = ???
  def getChildren: List[HtmlTag] = ???
  def generateHtml(): Unit
}
