package sml.instructions

import sml.Machine

case class AddInstruction(label: String, opcode: String, result: Int, op1: Int, op2: Int) extends MathInstruction {

  override def execute(m: Machine): Unit =
    m.regs(result) = m.regs(op1) + m.regs(op2)

  override def toString: String =
    super.toString + s" $op1 + $op2 to $result \n"
}

object AddInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): MathInstruction =
    new AddInstruction(label, "add", result, op1, op2)
}
