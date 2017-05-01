package prototype

object TestPrototypePattern extends App {
    var userAccessControl: AccessControl =
      AccessControlProvider.getAccessControlObject("USER")
    val userA = new User("User A", "USER Level", AccessControlProvider.getAccessControlObject("USER"))
    println("************************************")
    println(userA)
    
    userAccessControl = AccessControlProvider.getAccessControlObject("USER")
    val userB = new User("User B", "USER Level", userAccessControl)

    println("Changing access control of: " + userB.userName)

    userB.accessControl.access = "READ REPORTS"
    println(userB)
    println("************************************")
    println("verify user a's access was not affected by user b's change, and that a copy was indeed made")
    println(userA)
    println("************************************")
    
    val managerAccessControl: AccessControl =
      AccessControlProvider.getAccessControlObject("MANAGER")
    val userC = new User("User C", "MANAGER Level", managerAccessControl)
    println(userC)
}

