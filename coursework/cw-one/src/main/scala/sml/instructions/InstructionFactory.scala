package sml.instructions

import scala.util.Try

/**
  * InstructionFactory
  * I've used an object - can't think of a reason why this should not be a Singleton
 *
  * @author lmignot
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
