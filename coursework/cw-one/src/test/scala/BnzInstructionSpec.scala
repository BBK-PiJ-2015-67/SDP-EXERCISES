import sml.instructions.BnzInstruction
import sml.{Labels, Machine}

/**
  * Tests for the SubInstruction class
  * @author lmignot
  */
class BnzInstructionSpec extends BaseSpec {
  private final val Label = "L1"
  private final val Op = "bnz"
  private final val Reg = 3
  private final val Tgt = "L2"
  private final val Zero = 0

  describe("A BNZ instruction") {

    it("should initialise with the correct values") {
      Given("A BNZ instruction")
      When("The instruction is created")
      val bnz = BnzInstruction(Label, Reg, Tgt)

      Then("The values should be correct")
      bnz.label should be (Label)
      bnz.opcode should be (Op)
      bnz.reg should be (Reg)
      bnz.target should be (Tgt)

      And("toString() should be correct")
      bnz.toString() should be (s"${bnz.label}: ${bnz.opcode} if the value in register ${bnz.reg} is $Zero execute ${bnz
        .target}\n")
    }

    describe("Executing the instruction") {

    }
  }
}
