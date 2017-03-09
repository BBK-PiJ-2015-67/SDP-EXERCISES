package sml.instructions

import sml.Machine

/**
  * Instruction trait definition
  */
trait Instruction {

  /**
    * Label of instruction
    */
  val label: String

  /**
    * The operation code this instruction performs
    * eg. "add"
    */
  val opcode: String

  override def toString: String = label + ": " + opcode

  /**
    * Execute instruction on the provided Machine
    * @param m The Machine on which to execute instruction
    */
  def execute(m: Machine): Unit
}
