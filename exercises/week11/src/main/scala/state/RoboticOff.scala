package state

case class RoboticOff(r: Robot) extends RoboticState {

  def walk(): Unit = {
    r.state = r.roboticOn
    println("Walking...")
  }

  def cook(): Unit = println("Cannot cook, robot is off")

  def off(): Unit = println("Robot is already off")

}
