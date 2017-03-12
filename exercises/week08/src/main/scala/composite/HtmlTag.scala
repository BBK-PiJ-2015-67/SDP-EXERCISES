package composite

abstract class HtmlTag(tagName: String) {
  def setStartTag(tag: String): Unit

  def setEndTag(tag: String): Unit

  def setTagBody(body: String): Unit

  def generateHtml: String

  def addChildTag(htmlTag: HtmlTag): Unit = ???

  def removeChildTag(htmlTag: HtmlTag): Unit = ???

  def getChildren: List[HtmlTag] = ???
}