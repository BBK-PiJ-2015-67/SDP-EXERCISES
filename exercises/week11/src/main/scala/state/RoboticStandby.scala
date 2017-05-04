package state

case class RoboticStandby(r: Robot) extends RoboticState {

  def walk: String = {
    r.state = r.roboticOn
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
    println(RoboticStates.IsOff)
    RoboticStates.IsOff
  }

}
