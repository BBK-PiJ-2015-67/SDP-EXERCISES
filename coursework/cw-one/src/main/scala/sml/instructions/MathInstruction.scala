package sml.instructions

/**
  * Extends Instruction, adds fields required for a typical
  * math operation on the sml machine
  */
trait MathInstruction extends Instruction {
  /**
    * Register address where the result of the math operation
    * will be stored
    */
  val result: Int

  /**
    * First operand of the math operation
    */
  val op1: Int

  /**
    * Second operand of the math operation
    */
  val op2: Int
}
