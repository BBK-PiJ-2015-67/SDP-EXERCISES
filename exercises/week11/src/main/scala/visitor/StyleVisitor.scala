package visitor

case class StyleVisitor() extends Visitor {
  private lazy val ParentWidth = 58
  private lazy val ElWidth = 46

  override def visit(element: HtmlElement): Unit = applyWidth(element, ElWidth)
  override def visit(parentElement: HtmlParentElement): Unit = applyWidth(parentElement, ParentWidth)

  private def applyWidth(el: HtmlTag, w: Int): Unit = {
    el.setStartTag(el.getStartTag.filter(_ != '>') + s" style='width:${w}px;'>")
  }
}
