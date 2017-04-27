package chain

/**
  * Abstract class to handle common code used by all "File" Handler classes
  * avoiding repetition
  *
  * @param s The handler's name
  * @param fTypes list of File types this Handler supports
  */
abstract class FileHandler(s: String, fTypes: Vector[String]) extends Handler {

  private lazy val NotSupported = "File not supported"
  private var next: Handler = _

  /**
    * @see [[Handler.setHandler()]]
    */
  override def setHandler(handler: Handler): Handler = {
    next = handler
    this
  }

  /**
    * @see [[Handler.process()]]
    */
  override def process(file: File): String = file.fileType match {
    case t if fTypes.contains(t) =>
      val result = s"Process and saving $t file... by $s"
      println(result)
      result
    case _ if next != null =>
      println(s"$s forwards request to ${next.getHandlerName}")
      next.process(file)
    case _ => NotSupported
  }

  override def getHandlerName: String = s

}
