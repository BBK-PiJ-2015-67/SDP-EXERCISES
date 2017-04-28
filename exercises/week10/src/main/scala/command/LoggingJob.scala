package command

class LoggingJob extends Job {
  private var id: Int = 0
  private var _logging: Some[Logging] = _

  def setLogging(logging: Logging): Unit = _logging = Some(logging); id = id + 1

  override def run: Unit = {
    println(s"Job ID: $id executing logging jobs.")
    _logging.foreach(_.log())
  }
}
