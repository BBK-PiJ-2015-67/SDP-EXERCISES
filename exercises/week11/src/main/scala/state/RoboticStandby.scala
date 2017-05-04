package state

case class RoboticStandby(r: Robot) extends RoboticState {

  def walk(): Unit = {
    r.state = r.roboticOn
    println("Walking...")
  }

  def cook(): Unit = {
    r.state = r.roboticCook
    println("Cooking...")
  }

  def off(): Unit = {
    r.state = r.roboticOff
    println("Robot is off")
  }

}
