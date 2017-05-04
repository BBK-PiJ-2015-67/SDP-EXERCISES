package state

trait RoboticState {
  def walk: String
  def cook: String
  def off: String
}

object RoboticStates {
  lazy val IsWalking = "Walking..."
  lazy val IsCooking = "Cooking..."
  lazy val IsOff = "Robot is off"
  lazy val SwitchOff = "Robot is switched off"
  lazy val IsAlreadyOff = "Robot is already off"
  lazy val CannotCook = "Cannot cook, robot is off"
  lazy val CannotSwitchOffCooking =
    "Cannot switch off, robot is cooking"
}
