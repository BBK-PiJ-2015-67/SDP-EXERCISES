package prototype

/**
  * Defines a User's ACL
  *
  * @param controlLevel The control level, eg. USER, MANAGER, ADMIN, ANONYMOUS, etc.
  * @param access What the user can do
  */
case class AccessControl(controlLevel: String, var access: String) extends Prototype {}