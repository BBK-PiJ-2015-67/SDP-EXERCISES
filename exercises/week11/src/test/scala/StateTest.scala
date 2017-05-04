import test.BaseTest
import state._

class StateTest extends BaseTest {

  describe("A Robot") {
    it("Should start in the on state") {
      Given("A Robot")
      val robot = Robot()

      When("It's state is queried")
      val state = robot.state

      Then("The state should be RoboticOn")
      state shouldBe a [RoboticOn]
    }

    it("Should walk if in the on state") {
      Given("A Robot")
      val robot = Robot()

      When("It is told to walk")
      val msg = robot.walk
      val state = robot.state

      Then("The robot should be walking")
      msg should be (RoboticStates.IsWalking)

      And("The state should be RoboticStandby")
      state shouldBe a [RoboticStandby]
    }

    it("Should cook if in the on state") {
      Given("A Robot")
      val robot = Robot()

      When("It is told to cook")
      val msg = robot.cook
      val state = robot.state

      Then("The robot should be cooking")
      msg should be (RoboticStates.IsCooking)

      And("The state should be RoboticStandby")
      state shouldBe a [RoboticStandby]
    }

    it("Should switch off if done walking") {
      Given("A Robot that was walking")
      val robot = Robot()
      robot.walk

      When("It is in standby and told to switch off")
      val off = robot.off
      val state = robot.state

      Then("The robot should be switched off")
      off should be (RoboticStates.IsOff)

      And("The state should be RoboticOff")
      state shouldBe a [RoboticOff]
    }

    it("Should switch off if done cooking") {
      Given("A Robot that was cooking")
      val robot = Robot()
      robot.cook

      When("It is in standby and told to switch off")
      val off = robot.off
      val state = robot.state

      Then("The robot should be switched off")
      off should be (RoboticStates.IsOff)

      And("The state should be RoboticOff")
      state shouldBe a [RoboticOff]
    }

    it("Should not switch off if already off") {
      Given("A Robot that is off")
      val robot = Robot()
      robot.off

      When("It is asked to switch off")
      val off = robot.off
      val state = robot.state

      Then("The robot should already be switched off")
      off should be (RoboticStates.IsAlreadyOff)

      And("The state should be RoboticOff")
      state shouldBe a [RoboticOff]
    }

    it("Should not cook if it is off") {
      Given("A Robot that is off")
      val robot = Robot()
      robot.off

      When("It is asked to cook")
      val msg = robot.cook
      val state = robot.state

      Then("The robot should not be able to cook")
      msg should be (RoboticStates.CannotCook)

      And("The robot should be in standby")
      state shouldBe a [RoboticStandby]
    }
  }

}
