package sml.instructions

import sml.{Instruction, Machine}

case class AddInstruction(label: String, opcode: String, result: Int, op1: Int, op2: Int) extends
  Instruction(label, opcode) {

  override def execute(m: Machine): Unit =
    m.regs(result) = m.regs(op1) + m.regs(op2)

  override def toString(): String =
    super.toString + " " + op1 + " + " + op2 + " to " + result
}

object AddInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): AddInstruction =
    AddInstruction(label, "add", result, op1, op2)
}
