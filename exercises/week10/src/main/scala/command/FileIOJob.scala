package command

class FileIOJob extends Job {
  private var id: Int = 0
  private var _fileIO: Some[FileIO] = _

  def setFileIO(fileIO: FileIO): Unit = _fileIO = Some(fileIO); id = id + 1

  override def run: Unit = {
    println(s"Job ID: $id executing fileIO jobs.")
    _fileIO.foreach(_.execute())
  }
}
