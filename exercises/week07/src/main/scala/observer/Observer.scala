package observer

trait Observer {
  def update(desc: String): String

  def subscribe()

  def unSubscribe()
}
