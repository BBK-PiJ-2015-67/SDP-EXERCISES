package people

/**
  * Person class
  *
  * A person has a first and a last name
  */
class Person (val firstName: String, val lastName: String)

object Person {
  /**
    * Given a String containing a full name, returns a new Person
    * @param fullName The full name of the Person
    */
  def apply(fullName: String): Person = {
    val nameParts = fullName.split(" ")
    new Person(nameParts(0), nameParts(1))
  }
}
