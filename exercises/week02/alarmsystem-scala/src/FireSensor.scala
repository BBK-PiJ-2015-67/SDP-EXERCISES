import scala.util.Random

class FireSensor () extends Sensor {
  private val sensorType: String = "Fire sensor"
  private val location: String = "Lobby" // this should be passed through in the Constructor???
  private var batteryPercentage: Double = 100

  override def isTriggered: Boolean = Random.nextInt(100) < 5

  override def getLocation: String = location

  override def getSensorType: String = sensorType

  override def getBatteryPercentage: Double = {
    batteryPercentage -= 10; batteryPercentage
  }
}
