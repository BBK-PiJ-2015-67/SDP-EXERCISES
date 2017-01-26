import scala.collection.mutable

object ControlUnit

// Responsibilities:
// 1. maintain list of sensors
// 2. initialise sensors
// 3. check if sensors are triggered etc..
class ControlUnit (sensors: mutable.Buffer[Sensor]) {
  def pollSensors() {
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
