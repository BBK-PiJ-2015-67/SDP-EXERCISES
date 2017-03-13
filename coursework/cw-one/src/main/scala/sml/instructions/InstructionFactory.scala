package sml.instructions

import scala.util.Try

/**
  * Attempt to construct a specified instruction class
  */
object InstructionFactory {

  private val ClsPrefix: String = "sml.instructions."
  private val ClsSuffix: String = "Instruction"

  /**
    * Retrieve the Class that matches the opcode if available
    * @param opcode The type of instruction to get - eg. "add"
    * @return A Try, potentially containing the Class for the requested Instruction type
    *         or a Failure
    */
  def apply(opcode: String): Try[Class[_]] =
    Try(Class.forName(s"$ClsPrefix${opcode.capitalize}$ClsSuffix"))
}
