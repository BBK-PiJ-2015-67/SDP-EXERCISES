package sml.instructions

import sml.{Instruction, Machine}

trait Bnz extends Instruction

case class BnzInstruction(label: String, opcode: String, reg: Int, target: String) extends Bnz {

  override def execute(m: Machine): Unit = {
    if (m.regs(reg) != 0) {
      m.pc = m.prog.indexWhere(_.label == target)
    }
  }

  override def toString: String =
    super.toString + s" if the value in register $reg is 0 execute $target\n"
}

object BnzInstruction {
  def apply(label: String, reg: Int, tgt: String): BnzInstruction =
    BnzInstruction(label, "bnz", reg, tgt)
}
