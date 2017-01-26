import scala.collection.mutable.ListBuffer

object ControlUnit

// Responsibilities:
// 1. maintain list of sensors
// 2. initialise sensors
// 3. check if sensors are triggered etc..
class ControlUnit {
  def pollSensors() {
    val sensors = new ListBuffer[Sensor]()
    sensors += new FireSensor()
    sensors += new SmokeSensor()
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}
