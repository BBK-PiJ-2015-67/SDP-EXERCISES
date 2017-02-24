package sml.instructions

import sml.{Instruction, Machine}

/**
  * @author lmignot
  */
class OutInstruction (label: String, opcode: String, register: Int)
  extends Instruction(label, opcode) {

  override def execute(m: Machine): Unit = println(m.regs(register))

  override def toString(): String =
    super.toString + s" print contents of $register to console"
}
