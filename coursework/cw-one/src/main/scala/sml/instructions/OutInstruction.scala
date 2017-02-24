package sml.instructions

import sml.{Instruction, Machine}

trait Out extends Instruction

case class OutInstruction (label: String, opcode: String, register: Int) extends Out {

  override def execute(m: Machine): Unit = println(m.regs(register))

  override def toString: String =
    super.toString + s" print contents of $register to console"
}

object OutInstruction {
  def apply(label: String, result: Int): OutInstruction =
    OutInstruction(label, "sub", result)
}

