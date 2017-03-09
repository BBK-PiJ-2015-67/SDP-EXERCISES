package sml.instructions

import sml.Machine

/**
  * Multiply the values of 2 registers and store
  * result in specified register
  */
case class MulInstruction(label: String, opcode: String, result: Int, op1: Int, op2: Int) extends MathInstruction {

  /**
    * @see Instruction#execute(m: Machine)
    */
  override def execute(m: Machine): Unit =
    m.regs(result) = m.regs(op1) * m.regs(op2)

  /**
    * @see Instruction#toString()
    */
  override def toString: String =
    super.toString + s" $op1 * $op2 to $result \n"
}

object MulInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): MathInstruction =
    new MulInstruction(label, "mul", result, op1, op2)
}
