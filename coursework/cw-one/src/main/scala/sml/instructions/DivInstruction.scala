package sml.instructions

import sml.{Instruction, Machine}

trait Div extends Instruction

case class DivInstruction(label: String, opcode: String, result: Int, op1: Int, op2: Int) extends Div {

  override def execute(m: Machine): Unit =
    m.regs(result) = m.regs(op1) / m.regs(op2)

  override def toString: String =
    super.toString + s" $op1 / $op2 to $result \n"
}

object DivInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): DivInstruction =
    DivInstruction(label, "div", result, op1, op2)
}
