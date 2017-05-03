package memento

case class Originator(
  var x: Double,
  var y: Double,
  var careTaker: CareTaker
) {

  private final lazy val InitialKey = "INITIAL"
  private var lastUndoSavepoint: String = _

  createSavepoint(InitialKey)

  def createSavepoint(savepointName: String): Unit = {
    println(s"Saving state...$savepointName")
    careTaker.saveMemento(Memento(x, y), savepointName)
    lastUndoSavepoint = savepointName
  }

  def undo(): Unit = {
    undo(lastUndoSavepoint)
  }

  def undo(savepointName: String): Unit = {
    println(s"Undo at... $savepointName")
    val saved = careTaker.getMemento(savepointName)
    x = saved.x
    y = saved.y
    setOriginatorState(savepointName)
  }

  def undoAll(): Unit = {
    undo(InitialKey)
    println("Clearing all savepoints...")
    careTaker.clearSavepoints()
  }

  private def setOriginatorState(savepointName: String): Unit =
    lastUndoSavepoint = savepointName

  override def toString: String = s"X: $x, Y: $y"
}
