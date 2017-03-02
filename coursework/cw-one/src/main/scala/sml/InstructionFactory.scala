package sml

/**
  * InstructionFactory
  * I've used an object - can't think of a reason why this should not be a Singleton
  * @author lmignot
  */
object InstructionFactory {

  private final val ClsPrefix: String = "sml.instructions."
  private final val ClsSuffix: String = "Instruction"

  /**
    * Retrieve the Instruction class that matches the opcode if available
    * @param opcode The type of instruction to get - i.e. "add"
    * @return An Option potentially containing the Class for the requested Instruction type
    */
  def get(opcode: String): Option[Class[_]] = {
    try Some(Class.forName(s"$ClsPrefix${opcode.capitalize}$ClsSuffix"))
    catch {
      case _: ClassNotFoundException => None
    }
  }
}
