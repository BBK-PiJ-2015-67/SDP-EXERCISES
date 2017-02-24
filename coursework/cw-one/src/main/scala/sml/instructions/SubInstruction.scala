package sml.instructions

import sml.{Instruction, Machine}

trait Sub extends Instruction

case class SubInstruction(label: String, opcode: String, result: Int, op1: Int, op2: Int) extends Sub {

  override def execute(m: Machine): Unit =
    m.regs(result) = m.regs(op1) - m.regs(op2)

  override def toString: String =
    super.toString + s" $op1 - $op2 to $result \n"
}

object SubInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): SubInstruction =
    SubInstruction(label, "sub", result, op1, op2)
}
