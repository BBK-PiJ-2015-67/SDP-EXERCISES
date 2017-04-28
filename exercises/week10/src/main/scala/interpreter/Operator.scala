package interpreter

case class Operator(op: (Int, Int) => Int,
                    private val leftExpression: Expression,
                    private val rightExpression: Expression)
    extends Expression {

  override def interpret(): Int =
    op(leftExpression.interpret(), rightExpression.interpret())

}
