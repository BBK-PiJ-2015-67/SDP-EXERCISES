package state

case class RoboticOn(r: Robot) extends RoboticState {

  def walk: String = {
    println(RoboticStates.IsWalking)
    RoboticStates.IsWalking
  }

  def cook: String = {
    r.state = r.roboticCook
    println(RoboticStates.IsCooking)
    RoboticStates.IsCooking
  }

  def off: String = {
    r.state = r.roboticOff
    println(RoboticStates.SwitchOff)
    RoboticStates.SwitchOff
  }

}
