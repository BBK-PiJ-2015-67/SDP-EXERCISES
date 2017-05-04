package proxy.remoteproxy

import java.rmi.Naming
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject
import java.util.Date

object ReportGeneratorImpl extends App {
  try {
    val reportGenerator: ReportGenerator = new ReportGeneratorImpl()
    Naming.rebind("PizzaCoRemoteGenerator", reportGenerator)
  } catch {
    case e: Exception => e.printStackTrace()
  }
}

class ReportGeneratorImpl protected ()
  extends UnicastRemoteObject
  with ReportGenerator {

  @throws(classOf[RemoteException])
  override def generateDailyReport: String =
    s"""
      |********************Location X Daily Report********************
      | Location ID: 012
      | Today’s Date: ${new Date().toString}
      | Total Pizza Sell: 112
      | Total Sale: $$2534
      | Net Profit: $$1985
      |***************************************************************
    """.stripMargin
}
