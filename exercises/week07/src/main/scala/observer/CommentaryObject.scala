package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String)
  extends Subject with Commentary {

  private var state: String = ""

  def subscribeObserver(observer: Observer): Unit = subscribers = subscribers :+ observer

  def unSubscribeObserver(observer: Observer): Unit = subscribers = subscribers.filter(_ != observer)

  def notifyObservers(): Unit = subscribers.foreach(_.update(state))

  override def setDesc(desc: String): Unit = {
    state = desc
    notifyObservers()
  }
}
