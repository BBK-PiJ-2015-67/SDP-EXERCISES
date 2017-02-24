import sml.instructions.MulInstruction
import sml.{Labels, Machine}

/**
  * Tests for the MulInstruction class
  * @author lmignot
  */
class DivInstructionSpec extends BaseSpec {
  private final val Label = "L1"
  private final val OP = "div"
  private final val R1 = 1
  private final val R2 = 2
  private final val R3 = 3
  private final val ZERO = 0
  private final val ONE = 1
  private final val AMT1 = 12
  private final val AMT2 = 3
  private final val RES = AMT1 / AMT2

  describe("A DIV instruction") {

    it("should initialise with the correct values") {
      Given("A DIV instruction")
      When("The instruction is created")
      val ai: DivInstruction = DivInstruction(Label, R3, R1, R2)

      Then("The values should be correct")
      ai.label should be (Label)
      ai.opcode should be (OP)
      ai.result should be (R3)
      ai.op1 should be (R1)
      ai.op2 should be (R2)

      And("toString() should be correct")
      ai.toString() should be (s"${ai.label}: ${ai.opcode} ${ai.op1} / ${ai.op2} to ${ai.result}")
    }

    describe("Executing the instruction") {
      it("should store the product of specified registers in the correct register") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A MUL instruction")
        val ai: DivInstruction = DivInstruction(Label, R3, R1, R2)

        When("The instruction's op registers are initialised with the expected values")
        m.regs(R1) = AMT1
        m.regs(R2) = AMT2

        And("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (RES)
      }

      it("should correctly sum the values given any valid Int value") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A DIV instruction")
        val ai: DivInstruction = DivInstruction(Label, R3, R1, R2)

        When("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (ZERO)
      }

      it("should correctly sum the values given the same register for arguments") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A DIV instruction")
        val ai: DivInstruction = DivInstruction(Label, R1, R1, R1)

        When("The instruction's op register is initialised with the expected value")
        m.regs(R1) = AMT1

        And("The instruction is executed")
        ai.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R1) should be (ONE)
      }
    }
  }
}
