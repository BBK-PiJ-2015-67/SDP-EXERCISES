import scala.util.Random

class FireSensor () extends Sensor {
  private val ChanceOfTriggering = 5
  private val BatteryDrainPerPoll = 10
  private val SensorType: String = "Fire sensor"
  private val Location: String = "Lobby"

  private var batteryPercentage: Double = 100

  override def isTriggered: Boolean = {
    batteryPercentage -= BatteryDrainPerPoll
    Random.nextInt(100) < ChanceOfTriggering
  }

  override def getLocation: String = Location

  override def getSensorType: String = SensorType

  override def getBatteryPercentage: Double = batteryPercentage
}
