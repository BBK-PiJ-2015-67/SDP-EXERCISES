import sml.instructions.InstructionFactory

/**
  * @author lmignot
  */
class InstructionFactorySpec extends BaseSpec {

  describe("Instruction Factory") {
    it("should retrieve an Option containing the Class for the requested instruction") {
      Given("InstructionFactory")
      When("an instruction that exists is requested")
      val cls = InstructionFactory("add")
      Then("The Class should be available")
      cls.get shouldBe a [Class[_]]
      cls.isSuccess should be (true)
    }

    it("should, if no Class exists for the requested instruction, return None") {
      Given("InstructionFactory")
      When("an instruction that does not exist is requested")
      val cls = InstructionFactory("asdf")
      Then("The result should have failed")
      cls.isFailure should be (true)
    }
  }
}
