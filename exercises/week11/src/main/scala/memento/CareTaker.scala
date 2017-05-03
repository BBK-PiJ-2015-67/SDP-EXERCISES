package memento

import scala.collection.immutable.HashMap


case class CareTaker() {

  private var savepointStorage: Map[String, Memento] = new HashMap()

  def saveMemento(memento: Memento, savepointName: String): Unit =
    savepointStorage = savepointStorage + (savepointName -> memento)

  def getMemento(savepointName: String): Memento = savepointStorage(savepointName)

  def clearSavepoints(): Unit = savepointStorage = new HashMap()
}
