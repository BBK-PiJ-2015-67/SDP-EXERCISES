import sml.instructions.MulInstruction
import sml.{Labels, Machine}

/**
  * Tests for the MulInstruction class
  * @author lmignot
  */
class MulInstructionSpec extends BaseSpec {
  private final val Label = "L1"
  private final val OP = "mul"
  private final val R1 = 1
  private final val R2 = 2
  private final val R3 = 3
  private final val ZERO = 0
  private final val AMT = 8
  private final val RES = AMT * AMT

  describe("A MUL instruction") {

    it("should initialise with the correct values") {
      Given("A MUL instruction")
      When("The instruction is created")
      val mul = MulInstruction(Label, R3, R1, R2)

      Then("The values should be correct")
      mul.label should be (Label)
      mul.opcode should be (OP)
      mul.result should be (R3)
      mul.op1 should be (R1)
      mul.op2 should be (R2)

      And("toString() should be correct")
      mul.toString() should be (s"${mul.label}: ${mul.opcode} ${mul.op1} * ${mul.op2} to ${mul.result} \n")
    }

    describe("Executing the instruction") {
      it("should store the product of specified registers in the correct register") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A MUL instruction")
        val mul = MulInstruction(Label, R3, R1, R2)

        When("The instruction's op registers are initialised with the expected values")
        m.regs(R1) = AMT
        m.regs(R2) = AMT

        And("The instruction is executed")
        mul.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (RES)
      }

      it("should correctly multiply the values given any valid Int value") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A MUL instruction")
        val mul = MulInstruction(Label, R3, R1, R2)

        When("The instruction is executed")
        mul.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (ZERO)
      }

      it("should correctly multiply the values given the same register for arguments") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A MUL instruction")
        val mul = MulInstruction(Label, R1, R1, R1)

        When("The instruction's op register is initialised with the expected value")
        m.regs(R1) = AMT

        And("The instruction is executed")
        mul.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R1) should be (RES)
      }
    }
  }
}
