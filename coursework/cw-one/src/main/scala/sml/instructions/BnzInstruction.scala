package sml.instructions

import sml.Machine

trait Bnz extends Instruction {

  /**
    * Address of the register to evaluate
    */
  val register: Int

  /**
    * Instruction to execute if evaluation returns > 0
    */
  val target: String
}

/**
  * Instruct Machine to execute specific instruction if value in
  * specified register is > 0
  */
case class BnzInstruction(label: String, opcode: String, register: Int, target: String) extends Bnz {

  /**
    * @see Instruction#execute(m: Machine)
    */
  override def execute(m: Machine): Unit =
    if (m.regs(register) != 0) m.pc = m.prog.indexWhere(_.label == target)

  /**
    * @see Instruction#toString()
    */
  override def toString: String =
    super.toString + s" if the value in register $register is 0 execute $target\n"
}

object BnzInstruction {
  def apply(label: String, reg: Int, tgt: String): Bnz =
    new BnzInstruction(label, "bnz", reg, tgt)
}
