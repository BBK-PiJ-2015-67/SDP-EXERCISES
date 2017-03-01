import sml.{Instruction, InstructionFactory}
import sml.instructions.AddInstruction

/**
  * @author lmignot
  */
class InstructionFactorySpec extends BaseSpec {

  describe("Instruction Factory") {
    it("should retrieve an Option containing the Class for the requested instruction") {
      Given("InstructionFactory")
      When("get is called for an instruction that exists")
      val cls = InstructionFactory.get("add").get
      Then("The Class should be returned")
      cls shouldBe a [Class[_]]
    }

    it("should, if no Class exists for the requested instruction, return None") {
      Given("InstructionFactory")
      When("get is called for an instruction that does not exist")
      val cls = InstructionFactory.get("asdf")
      Then("The result should be None")
      cls shouldBe None
    }
  }
}
