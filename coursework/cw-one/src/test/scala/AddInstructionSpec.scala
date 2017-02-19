import sml.{AddInstruction, Labels, Machine}

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
      val m: Machine = new Machine(Labels(), Vector())
      val ai: AddInstruction = AddInstruction(Label, R3, R1, R2)
      m.regs(R1) = AMT
      m.regs(R2) = AMT

      ai.label should be (Label)
      ai.op should be (OP)
      ai.result should be (R3)
      ai.op1 should be (R1)
      ai.op2 should be (R2)
    }

    describe("Executing the instruction") {
      it("should sum the values of 2 registers and store the result in the correct register") {
        val m: Machine = new Machine(Labels(), Vector())
        val ai: AddInstruction = AddInstruction(Label, R3, R1, R2)
        m.regs(R1) = AMT
        m.regs(R2) = AMT

        ai.execute(m)
        m.regs(R3) should be (RES)
      }

      it("should correctly sum the values given any valid Int value") {
        val m: Machine = new Machine(Labels(), Vector())
        val ai: AddInstruction = AddInstruction(Label, R3, R1, R2)

        ai.execute(m)
        m.regs(R3) should be (ZERO)
      }

      it("should correctly sum the values given the same register for arguments") {
        val m: Machine = new Machine(Labels(), Vector())
        val ai: AddInstruction = AddInstruction(Label, R1, R1, R1)
        m.regs(R1) = AMT

        ai.execute(m)
        m.regs(R1) should be (RES)
      }
    }
  }
}
