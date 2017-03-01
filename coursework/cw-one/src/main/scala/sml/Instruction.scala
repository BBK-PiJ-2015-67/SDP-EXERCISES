package sml

/**
  * Instruction trait for SML Machine
  */
trait Instruction {

  /**
    * The Label for this instruction
    */
  val label: String

  /**
    * The operation code this instruction performs
    */
  val opcode: String

  override def toString: String = label + ": " + opcode

  /**
    * Execute this instruction on the provided Machine
    * @param m The Machine to execute the instruction on
    */
  def execute(m: Machine): Unit
}