package state

case class RoboticOff(r: Robot) extends RoboticState {

  def walk: String = {
    r.state = r.roboticOn
    println(RoboticStates.IsWalking)
    RoboticStates.IsWalking
  }

  def cook: String = {
    println(RoboticStates.CannotCook)
    RoboticStates.CannotCook
  }

  def off: String = {
    println(RoboticStates.IsAlreadyOff)
    RoboticStates.IsAlreadyOff
  }

}
