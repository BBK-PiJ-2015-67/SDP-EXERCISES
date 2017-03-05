package observer

class SMSUsers(s: Subject, msg: String) extends Observer {

  def update(desc: String): String = {
    println(s"$msg: $desc")
    desc
  }

  def subscribe(): Unit = s.subscribeObserver(this)

  def unSubscribe(): Unit = s.unSubscribeObserver(this)
}
