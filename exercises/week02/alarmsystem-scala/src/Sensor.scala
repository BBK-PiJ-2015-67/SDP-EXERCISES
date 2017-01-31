/**
  * Answer to question 6: method "getBatteryPercentage" fails LSP
  * because a sensor that is not battery powered would still need to implement
  * in some way "getBatteryPercentage"
  */
trait Sensor {
  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String

  def getBatteryPercentage: Double
}
