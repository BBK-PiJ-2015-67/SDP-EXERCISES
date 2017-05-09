import sml.instructions.DivInstruction
import sml.{Labels, Machine}

/**
  * Tests for the MulInstruction class
  * @author lmignot
  */
class DivInstructionSpec extends BaseSpec {
  private val Label = "L1"
  private val OP = "div"
  private val R1 = 1
  private val R2 = 2
  private val R3 = 3
  private val ZERO = 0
  private val ONE = 1
  private val AMT1 = 12
  private val AMT2 = 3
  private val RES = AMT1 / AMT2

  describe("A DIV instruction") {

    it("should initialise with the correct values") {
      Given("A DIV instruction")
      When("The instruction is created")
      val div = DivInstruction(Label, R3, R1, R2)

      Then("The values should be correct")
      div.label should be (Label)
      div.opcode should be (OP)
      div.result should be (R3)
      div.op1 should be (R1)
      div.op2 should be (R2)

      And("toString() should be correct")
      div.toString() should be (s"${div.label}: ${div.opcode} ${div.op1} / ${div.op2} to ${div.result} \n")
    }

    describe("Executing the instruction") {
      it("should store the quotient of specified registers in the correct register") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A MUL instruction")
        val div = DivInstruction(Label, R3, R1, R2)

        When("The instruction's op registers are initialised with the expected values")
        m.regs(R1) = AMT1
        m.regs(R2) = AMT2

        And("The instruction is executed")
        div.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R3) should be (RES)
      }

      it(s"should throw an exception when dividing by $ZERO") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        When(s"A DIV instruction is created with $ZERO as the divisor")
        val div = DivInstruction(Label, R3, R1, R2)

        Then("An java.lang.ArithmeticException shoud be thrown")
        a [java.lang.ArithmeticException] should be thrownBy (div.execute(m))
      }

      it("should correctly divide the values given the same register for arguments") {
        Given("A Machine")
        val m: Machine = new Machine(Labels(), Vector())

        And("A DIV instruction")
        val div = DivInstruction(Label, R1, R1, R1)

        When("The instruction's op register is initialised with the expected value")
        m.regs(R1) = AMT1

        And("The instruction is executed")
        div.execute(m)

        Then("The result Machine register should have the correct value")
        m.regs(R1) should be (ONE)
      }
    }
  }
}
