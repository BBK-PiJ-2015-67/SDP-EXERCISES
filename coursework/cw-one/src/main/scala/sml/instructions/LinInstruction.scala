package sml.instructions

import sml.Machine

trait Lin extends Instruction {

  /**
    * Address of the register where the value will be stored
    */
  val register: Int

  /**
    * Value to store in registry
    */
  val value: Int
}

/**
  * Store a value in specified register
  */
case class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Lin {

  /**
    * @see Instruction#execute(m: Machine)
    */
  override def execute(m: Machine): Unit = m.regs(register) = value

  /**
    * @see Instruction#toString()
    */
  override def toString: String = {
    super.toString + s" register $register value is $value \n"
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int): Lin =
    new LinInstruction(label, "lin", register, value)
}
