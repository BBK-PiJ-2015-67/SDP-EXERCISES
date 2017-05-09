import sml.instructions.SubInstruction
import sml.{Labels, Machine}

/**
  * Tests for the SubInstruction class
  * @author lmignot
  */
class SubInstructionSpec extends BaseSpec {
  private val Label = "L1"
  private val OP = "sub"
  private val R1 = 1
  private val R2 = 2
  private val R3 = 3
  private val ZERO = 0
  private val AMT1 = 78
  private val AMT2 = 36
  private val RES = AMT1 - AMT2

  describe("A SUB instruction") {

    it("should initialise with the correct values") {
      Given("A SUB instruction")
      When("The instruction is created")
      val sub = SubInstruction(Label, R3, R1, R2)

      Then("The values should be correct")
      sub.label should be (Label)
      sub.opcode should be (OP)
      sub.result should be (R3)
      sub.op1 should be (R1)
      sub.op2 should be (R2)

      And("toString() should be correct")
      sub.toString() should be (s"${sub.label}: ${sub.opcode} ${sub.op1} - ${sub.op2} to ${sub.result} \n")
    }

    describe("Executing the instruction") {
      it("should subtract the values of 2 registers and store the result in the correct register") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A SUB instruction")
        val sub = SubInstruction(Label, R3, R1, R2)

        When("The instruction's op registers are initialised with the expected values")
        m.regs(R1) = AMT1
        m.regs(R2) = AMT2

        And("The instruction is executed")
        sub.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (RES)
      }

      it("should correctly subtract the values given any valid Int value") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A SUB instruction")
        val ai = SubInstruction(Label, R3, R1, R2)

        When("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (ZERO)
      }

      it("should correctly subtract the values given the same register for arguments") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A SUB instruction")
        val ai = SubInstruction(Label, R1, R1, R1)

        When("The instruction's op register is initialised with the expected value")
        m.regs(R1) = AMT1

        And("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R1) should be (ZERO)
      }
    }
  }
}
