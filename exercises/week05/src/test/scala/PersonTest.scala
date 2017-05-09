import org.scalatest.FunSpec
import people._

class PersonTest extends FunSpec {
  val FirstName1 = "Wade"
  val LastName1 = "Wilson"
  val FullName1 = s"$FirstName1 $LastName1"
  val FirstName2 = "Peter"
  val LastName2 = "Quill"
  val FullName2 = s"$FirstName2 $LastName2"
  val FirstName3 = "Jessica"
  val LastName3 = "Jones"
  val FullName3 = s"$FirstName3 $LastName3"
  val FirstName4 = "Bruce"
  val LastName4 = "Wayne"
  val FullName4 = s"$FirstName3 $LastName4"
  val FirstNameOnly = "Bruce"
  val LastNameOnly = " Wayne"

  describe("A Person") {
    it("should have a first and last name") {
      assert(Person(FirstName1, LastName1).firstName == FirstName1)
      assert(Person(FirstName1, LastName1).lastName == LastName1)
    }

    it("apply in companion object takes a full name and returns appropriate Person") {
      assert(Person(FullName2).firstName == FirstName2)
      assert(Person(FullName2).lastName == LastName2)
    }

    it("apply creates a person even if only a firstname is provided") {
      assert(Person(FirstNameOnly).firstName == FirstName4)
      assert(Person(FirstNameOnly).lastName == "")
    }

    it("apply creates a person even if only a lastname is provided") {
      assert(Person(LastNameOnly).firstName == "")
      assert(Person(LastNameOnly).lastName == LastName4)
    }
  }
}
