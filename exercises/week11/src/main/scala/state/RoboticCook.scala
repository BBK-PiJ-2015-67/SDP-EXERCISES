package state

case class RoboticCook(r: Robot) extends RoboticState {

  def walk: String = {
    r.state = r.roboticOn
    println(RoboticStates.IsWalking)
    RoboticStates.IsWalking
  }

  def cook: String = {
    println(RoboticStates.IsCooking)
    RoboticStates.IsCooking
  }

  def off: String = {
    println(RoboticStates.CannotSwitchOffCooking)
    RoboticStates.CannotSwitchOffCooking
  }

}
