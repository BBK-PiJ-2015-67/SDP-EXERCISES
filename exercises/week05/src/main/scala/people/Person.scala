package people

/**
  * Person class
  *
  * A person has a first and a last name
  */
case class Person (firstName: String, lastName: String)

object Person {
  /**
    * Given a String containing a space-separated name,
    * returns a new Person
    *
    * @param fullName The full name of the Person
    */
  def apply(fullName: String): Person = {
    val parts = fullName.split(" ")
    Person(parts(0), if (parts.length == 2) parts(1) else "")
  }
}
