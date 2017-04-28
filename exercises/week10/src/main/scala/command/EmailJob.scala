package command

class EmailJob extends Job {
  private var id: Int = 0
  private var _email: Some[Email] = _

  def setEmail(email: Email): Unit = _email = Some(email); id = id + 1

  override def run: Unit = {
    println(s"Job ID: $id executing email jobs.")
    _email.foreach(_.sendEmail())
  }
}
