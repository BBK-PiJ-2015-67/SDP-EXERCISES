import sml.instructions.{AddInstruction, BnzInstruction}
import sml.{Labels, Machine}

/**
  * Tests for the SubInstruction class
  * @author lmignot
  */
class BnzInstructionSpec extends BaseSpec {
  private final val Label1 = "L1"
  private final val Label2 = "L2"
  private final val Label3 = "L3"
  private final val Op = "bnz"
  private final val Reg1 = 1
  private final val Reg2 = 2
  private final val Reg3 = 3
  private final val Tgt = "L1"
  private final val Zero = 0
  private final val Seven = 7

  describe("A BNZ instruction") {

    it("should initialise with the correct values") {
      Given("A BNZ instruction")
      When("The instruction is created")
      val bnz = BnzInstruction(Label1, Reg1, Tgt)

      Then("The values should be correct")
      bnz.label should be (Label1)
      bnz.opcode should be (Op)
      bnz.reg should be (Reg1)
      bnz.target should be (Tgt)

      And("toString() should be correct")
      bnz.toString() should be (s"${bnz.label}: ${bnz.opcode} if the value in register ${bnz.reg} is $Zero execute ${bnz
        .target}\n")
    }

    it("Executing the instruction") {
      Given("A Machine and some instructions")
      val bnz = BnzInstruction(Label3, Reg1, Tgt)
      val add1 = AddInstruction(Label1, Reg2, Reg2, Reg3)
      val add2 = AddInstruction(Label2, Reg2, Reg2, Reg3)
      val m = new Machine(Labels(), Vector(add1, add2, bnz))
      m.regs(Reg1) = Seven

      When("A BnzInstruction is executed")
      bnz.execute(m)

      Then("The machine should switch to the target instruction")
      m.pc should be (Zero)
      m.prog.indexWhere(_.label == Tgt) should be (m.prog.indexOf(add1))

    }
  }
}
