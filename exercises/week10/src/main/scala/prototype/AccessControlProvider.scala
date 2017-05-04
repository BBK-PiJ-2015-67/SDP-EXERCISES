package prototype

import scala.collection.immutable.HashMap

object AccessControlProvider {

  println("Fetching data from external resources and creating access control objects...")

  private lazy val map: HashMap[String, AccessControl] = HashMap(
    ("USER", AccessControl("USER", "DO_WORK")),
    ("ADMIN", AccessControl("ADMIN", "ADD/REMOVE USERS")),
    ("MANAGER", AccessControl("MANAGER", "GENERATE/READ REPORTS")),
    ("VP", AccessControl("VP", "MODIFY REPORTS"))
  )

  def getAccessControlObject(controlLevel: String): AccessControl =
    map.get(controlLevel) match {
      case Some(ac) => ac.copy(ac.controlLevel, ac.access)
      case None => AccessControl("ANONYMOUS", "ACCESS DENIED")
    }

}
