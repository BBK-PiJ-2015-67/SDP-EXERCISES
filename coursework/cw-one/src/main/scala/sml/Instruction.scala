package sml

trait Instruction {

  val label: String
  val opcode: String

  override def toString: String = label + ": " + opcode

  def execute(m: Machine): Unit
}