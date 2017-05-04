package visitor

case class StyleVisitor() extends Visitor {
  private lazy val StyleSuffix = " style='width:58px;'>"

  override def visit(element: HtmlElement): Unit = applyStyle(element)
  override def visit(parentElement: HtmlParentElement): Unit = applyStyle(parentElement)

  private def applyStyle(el: HtmlTag): Unit = {
    el.setStartTag(el.getStartTag.filter(_ != '>') + StyleSuffix)
  }
}
