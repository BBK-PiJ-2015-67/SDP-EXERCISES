package facadepattern

case class ScheduleServerImpl() extends ScheduleServer {
  override def startBooting: Unit = println("starting up...")

  override def readSystemConfigFile: Unit = println("reading config file...")

  override def init: Unit = println("initializing...")

  override def initializeContext: Unit = println("initializing context...")

  override def initializeListeners: Unit = println("initializing listeners...")

  override def createSystemObjects: Unit = println("creating system objects...")

  override def releaseProcesses: Unit = println("releasing processes...")

  override def destory: Unit = println("destroying...")

  override def destroySystemObjects: Unit = println("destroying system objects...")

  override def destoryListeners: Unit = println("destroying listeners...")

  override def destoryContext: Unit = println("destroying context...")

  override def shutdown: Unit = println("shutting down...")
}
