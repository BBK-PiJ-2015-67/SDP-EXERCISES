import sml.instructions.{LinInstruction, SubInstruction}
import sml.{Labels, Machine}

/**
  * Tests for the LinInstruction class
  * @author lmignot
  */
class LinInstructionSpec extends BaseSpec {
  private val Label = "L1"
  private val OP = "lin"
  private val REG = 3
  private val VALUE = 99

  describe("A LIN instruction") {

    it("should initialise with the correct values") {
      Given("A LIN instruction")
      When("The instruction is created")
      val lin = LinInstruction(Label, REG, VALUE)

      Then("The values should be correct")
      lin.label should be (Label)
      lin.opcode should be (OP)
      lin.register should be (REG)
      lin.value should be (VALUE)

      And("toString() should be correct")
      lin.toString() should be (s"${lin.label}: ${lin.opcode} register $REG value is $VALUE \n")
    }

    describe("Executing the instruction") {
      it("should store the value in the correct register") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A LIN instruction")
        val lin = LinInstruction(Label, REG, VALUE)

        When("The instruction is executed")
        lin.execute(m)

        Then("The Machine register should have the correct value")
        m.regs(REG) should be (VALUE)
      }
    }
  }
}
