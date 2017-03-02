package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.nonEmpty) {
        labels.add(fields(0))
        val clsOption = InstructionFactory.get(fields(1))
        if (clsOption.isEmpty) {
          println(s"Unknown instruction ${fields(1)}")
        } else {
          val cls = clsOption.get
          val cons = cls.getConstructors.toList.head
          val args = fields.map {
            case i if i.matches("\\d+") => new Integer(i)
            case f => f
          }
          try {
            program = program :+ cons.newInstance(args: _*).asInstanceOf[Instruction]
          } catch {
            case _: IllegalArgumentException => println(s"Args did not match for instruction: ${cls.getSimpleName}")
          }
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
