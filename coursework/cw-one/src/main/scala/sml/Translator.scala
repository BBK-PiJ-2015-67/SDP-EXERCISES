package sml

import scala.util.Try

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
        val args = fields.map {
          case i if i.matches("\\d+") => new Integer(i)
          case f => f
        }
        val cons = InstructionFactory.get(fields(1)).map(x => x.getConstructors.toList.head)
        val inst = Try(cons.get.newInstance(args: _*).asInstanceOf[Instruction])
        if (inst.isSuccess) program = program :+ inst.get else println(s"Unable to translate $line")
      }
    }
    new Machine(labels, program)
  }

}

object Translator {
  def apply(file: String) = new Translator(file)
}
