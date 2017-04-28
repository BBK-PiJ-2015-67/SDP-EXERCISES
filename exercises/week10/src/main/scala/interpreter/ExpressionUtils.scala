package interpreter

object ExpressionUtils {

  def isOperator(s: String): Boolean = s match {
    case "+" | "-" | "*" | "/" => true
    case _ => false
  }

  def getOperator(s: String, left: Expression, right: Expression): Expression = s match {
    case "+" => Add(left, right)
    case "-" => Sub(left, right)
    case "*" => Product(left, right)
    case "/" => Div(left, right)
    case _ => () => ???
  }
}
