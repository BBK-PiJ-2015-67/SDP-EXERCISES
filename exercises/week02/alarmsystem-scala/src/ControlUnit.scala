object ControlUnit

// This set of comments is to answer the question in Exercise 5.
// Responsibilities:
// 1. check if sensors are triggered etc.. (poll the sensors)
class ControlUnit (sensors: List[Sensor]) {
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
