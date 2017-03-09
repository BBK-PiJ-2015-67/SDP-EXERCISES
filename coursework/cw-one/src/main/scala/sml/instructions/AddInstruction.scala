package sml.instructions

import sml.Machine

/**
  * Add the values in 2 registers and store
  * result in specified register
  */
case class AddInstruction(label: String, opcode: String, result: Int, op1: Int, op2: Int) extends MathInstruction {

  /**
    * @see Instruction#execute(m: Machine)
    */
  override def execute(m: Machine): Unit =
    m.regs(result) = m.regs(op1) + m.regs(op2)

  /**
    * @see Instruction#toString()
    */
  override def toString: String =
    super.toString + s" $op1 + $op2 to $result \n"
}

object AddInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): MathInstruction =
    new AddInstruction(label, "add", result, op1, op2)
}
