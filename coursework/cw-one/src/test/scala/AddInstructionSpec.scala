import sml.instructions.AddInstruction
import sml.{Labels, Machine}

/**
  * Tests for the AddInstruction class
  * @author lmignot
  */
class AddInstructionSpec extends BaseSpec {
  private final val Label = "L1"
  private final val OP = "add"
  private final val R1 = 1
  private final val R2 = 2
  private final val R3 = 3
  private final val ZERO = 0
  private final val AMT = 72
  private final val RES = AMT * 2

  describe("An ADD instruction") {

    it("should initialise with the correct values") {
      Given("An ADD instruction")
      When("The instruction is created")
      val ai = AddInstruction(Label, R3, R1, R2)

      Then("The values should be correct")
      ai.label should be (Label)
      ai.opcode should be (OP)
      ai.result should be (R3)
      ai.op1 should be (R1)
      ai.op2 should be (R2)

      And("toString() should be correct")
      ai.toString() should be (s"${ai.label}: ${ai.opcode} ${ai.op1} + ${ai.op2} to ${ai.result} \n")
    }

    describe("Executing the instruction") {
      it("should sum the values of 2 registers and store the result in the correct register") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("An ADD instruction")
        val ai = AddInstruction(Label, R3, R1, R2)

        When("The instruction's op registers are initialised with the expected values")
        m.regs(R1) = AMT
        m.regs(R2) = AMT

        And("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (RES)
      }

      it("should correctly sum the values given any valid Int value") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("An ADD instruction")
        val ai = AddInstruction(Label, R3, R1, R2)

        When("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (ZERO)
      }

      it("should correctly sum the values given the same register for arguments") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("An ADD instruction")
        val ai = AddInstruction(Label, R1, R1, R1)

        When("The instruction's op register is initialised with the expected value")
        m.regs(R1) = AMT

        And("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R1) should be (RES)
      }
    }
  }
}
