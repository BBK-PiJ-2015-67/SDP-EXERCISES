package proxy.remoteproxy

import java.rmi.Remote
import java.rmi.RemoteException

trait ReportGenerator extends Remote {
  // Looked up declaring a method that throws an exception in Scala here:
  // http://alvinalexander.com/scala/how-to-declare-scala-methods-throws-exceptions
  @throws(classOf[RemoteException])
  def generateDailyReport: String
}
