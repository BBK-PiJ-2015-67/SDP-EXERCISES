package command

case class SmsJob() extends Job {
  private var id: Int = 0
  private var _sms: Some[Sms] = _

  def setSms(sms: Sms): Unit = _sms = Some(sms); id = id + 1

  override def run: Unit = {
    println(s"Job ID: $id executing sms jobs.")
    _sms.foreach(_.sendSms())
  }
}
