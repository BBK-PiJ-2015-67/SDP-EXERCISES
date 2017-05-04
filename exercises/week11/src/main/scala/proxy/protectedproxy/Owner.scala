package proxy.protectedproxy

class Owner extends Staff {
  private var reportGenerator: ReportGeneratorProxy = _

  override def isOwner: Boolean = true

  override def setReportGenerator(
    reportGenerator: ReportGeneratorProxy
  ): Unit = this.reportGenerator = reportGenerator

  def generateDailyReport: String = reportGenerator.generateDailyReport
}
