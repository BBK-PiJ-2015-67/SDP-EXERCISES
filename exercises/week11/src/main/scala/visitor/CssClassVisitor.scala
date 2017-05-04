package visitor

case class CssClassVisitor() extends Visitor {
  private lazy val CssSuffix = " class='visitor'>"

  override def visit(element: HtmlElement): Unit = applyClass(element)
  override def visit(parentElement: HtmlParentElement): Unit = applyClass(parentElement)

  private def applyClass(el: HtmlTag): Unit = {
    el.setStartTag(el.getStartTag.filter(_ != '>') + CssSuffix)
  }
}
