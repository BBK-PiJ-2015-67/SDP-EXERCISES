package interpreter

object ExpressionUtils {

  /**
    * Test whether a given string matches a recognised [[Operator]]
    * @param s The String to test
    * @return True if the operator is recognised, else False
    */
  def isOperator(s: String): Boolean = s match {
    case "+" | "-" | "*" | "/" => true
    case _ => false
  }

  /**
    * Get an Operator matching the given String
    *
    * @param s String representing an [[Operator]]
    * @param left Left-hand [[Expression]]
    * @param right Right-hand [[Expression]]
    * @return The Operator that matches the given operation
    * @throws NotImplementedError if the Operator has not been implemented
    */
  def getOperator(s: String, left: Expression, right: Expression): Expression = s match {
    case "+" => Operator(_ + _, left, right)
    case "-" => Operator(_ - _, left, right)
    case "*" => Operator(_ * _, left, right)
    case "/" => Operator(_ / _, left, right)
    case _ => () => throw new NotImplementedError("Operator not implemented")
  }
}
