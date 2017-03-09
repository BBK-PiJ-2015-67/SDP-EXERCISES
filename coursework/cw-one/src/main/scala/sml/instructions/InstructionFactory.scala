package sml.instructions

import scala.util.Try

/**
  * Attempt to construct a specified instruction class
  */
object InstructionFactory {

  private final val ClsPrefix: String = "sml.instructions."
  private final val ClsSuffix: String = "Instruction"

  /**
    * Retrieve the Instruction class that matches the opcode if available
    * @param opcode The type of instruction to get - i.e. "add"
    * @return A Try potentially containing the Class for the requested Instruction type
    *         or a Failure
    */
  def apply(opcode: String): Try[Class[_]] =
    Try(Class.forName(s"$ClsPrefix${opcode.capitalize}$ClsSuffix"))
}
