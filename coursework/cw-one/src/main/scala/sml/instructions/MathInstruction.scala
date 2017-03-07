package sml.instructions

/**
  * A MathInstruction extends on an Instruction
  * by adding further fields required for a typical
  * Math operation on the sml machine
  */
trait MathInstruction extends Instruction {
  /**
    * The register the result of the math operation
    * will be stored in
    */
  val result: Int

  /**
    * The first operand of the instruction
    */
  val op1: Int

  /**
    * The second operand of the instruction
    */
  val op2: Int
}
