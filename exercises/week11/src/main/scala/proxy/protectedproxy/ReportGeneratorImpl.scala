package proxy.protectedproxy

import java.util.Date

case class ReportGeneratorImpl() extends ReportGenerator {
  override def generateDailyReport: String =
    s"""********************Location X Daily Report********************
       | Location ID: 012
       | Today’s Date: ${new Date().toString}
       | Total Pizza Sell: 112
       | Total Sale: $$2534
       | Net Profit: $$1985
       |***************************************************************
    """.stripMargin
}
