package sml.instructions

import sml.Machine

/**
  * Subtract the value at op2 from value at op1 and store the
  * result in specified register
  */
case class SubInstruction(label: String, opcode: String, result: Int, op1: Int, op2: Int) extends MathInstruction {

  /**
    * @see Instruction#execute(m: Machine)
    */
  override def execute(m: Machine): Unit =
    m.regs(result) = m.regs(op1) - m.regs(op2)

  override def toString: String =
    super.toString + s" $op1 - $op2 to $result \n"
}

object SubInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): MathInstruction =
    new SubInstruction(label, "sub", result, op1, op2)
}
