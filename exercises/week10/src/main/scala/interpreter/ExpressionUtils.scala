package interpreter

object ExpressionUtils {

  def isOperator(s: String): Boolean = s match {
    case "+" | "-" | "*" | "/" => true
    case _ => false
  }

  def getOperator(s: String, left: Expression, right: Expression): Expression = s match {
    case "+" => Operator(_ + _, left, right)
    case "-" => Operator(_ - _, left, right)
    case "*" => Operator(_ * _, left, right)
    case "/" => Operator(_ / _, left, right)
    case _ => () => ???
  }
}
