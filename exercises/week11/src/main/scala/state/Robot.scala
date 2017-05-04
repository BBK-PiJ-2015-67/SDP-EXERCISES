package state

case class Robot() extends RoboticState {
  var roboticOn: RoboticState = RoboticOn(this)
  var roboticCook: RoboticState = RoboticCook(this)
  var roboticOff: RoboticState = RoboticOff(this)
  var roboticStandby: RoboticState = RoboticStandby(this)

  var state: RoboticState = roboticOn

  override def walk: String = {
    val res = state.walk
    state = roboticStandby
    res
  }

  override def cook: String = {
    val res = state.cook
    state = roboticStandby
    res
  }

  override def off: String = state.off
}
