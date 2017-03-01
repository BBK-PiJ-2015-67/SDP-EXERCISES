package sml

/**
  * InstructionFactory
  * I've used an object - can't think of a reason why this should not be a Singleton
  * @author lmignot
  */
object InstructionFactory {
  /**
    * Retrieve the Instruction class that matches the opcode if available
    * @param opcode The type of instruction to get - i.e. "add"
    * @return An Option potentially containing the Class for the requested Instruction type
    */
  def get(opcode: String): Option[Class[_]] = {
    try {
      val cls = Class.forName("sml.instructions." + opcode.capitalize + "Instruction")
      Some(cls)
    } catch {
      case _: ClassNotFoundException => None
    }
  }
}
