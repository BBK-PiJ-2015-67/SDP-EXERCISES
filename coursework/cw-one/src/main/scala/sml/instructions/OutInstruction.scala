package sml.instructions

import sml.Machine

trait Out extends Instruction {

  /**
    * The register that contains the value to print
    */
  val register: Int
}

/**
  * Print the value of specified register
  */
case class OutInstruction (label: String, opcode: String, register: Int) extends Out {

  /**
    * @see Instruction#execute(m: Machine)
    */
  override def execute(m: Machine): Unit = println(m.regs(register))

  /**
    * @see Instruction#toString()
    */
  override def toString: String =
    super.toString + s" print contents of $register to console\n"
}

object OutInstruction {
  def apply(label: String, result: Int): Out =
    new OutInstruction(label, "out", result)
}

