package sml.instructions

import sml.Machine

trait Lin extends Instruction {
  val register: Int
  val value: Int
}

case class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Lin {

  override def execute(m: Machine): Unit = m.regs(register) = value

  override def toString: String = {
    super.toString + " register " + register + " value is " + value + "\n"
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int): Lin =
    new LinInstruction(label, "lin", register, value)
}
