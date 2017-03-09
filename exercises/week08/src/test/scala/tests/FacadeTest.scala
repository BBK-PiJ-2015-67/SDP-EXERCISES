package tests

import facadepattern._

/**
  * Practice using Mockito for testing
  * Testing ScheduleServerFacade, ensuring that the appropriate api methods
  * are called when the simpler api is called
  *
  * @author lmignot
  */
class FacadeTest extends BaseTest {

  describe("ScheduleServerFacade") {
    it("should call the required methods when startServer() is called") {
      val scheduleServer = mock[ScheduleServerImpl]

      Given("a ScheduleServerFacade")
      val facade = ScheduleServerFacade(scheduleServer)

      When("startServer() is called")
      Then("the expected methods should have been called on the scheduleServer")
      inSequence {
        (scheduleServer.startBooting _).expects()
        (scheduleServer.readSystemConfigFile _).expects()
        (scheduleServer.init _).expects()
        (scheduleServer.initializeContext _).expects()
        (scheduleServer.initializeListeners _).expects()
        (scheduleServer.createSystemObjects _).expects()
      }

      facade.startServer()
    }

    it("should call the required methods when stopServer() is called") {
      val scheduleServer = mock[ScheduleServerImpl]

      Given("a ScheduleServerFacade")
      val facade = ScheduleServerFacade(scheduleServer)

      When("stopServer() is called")
      Then("the expected methods should have been called on the scheduleServer")
      inSequence {
        (scheduleServer.releaseProcesses _).expects()
        (scheduleServer.destroy _).expects()
        (scheduleServer.destroySystemObjects _).expects()
        (scheduleServer.destroyListeners _).expects()
        (scheduleServer.destroyContext _).expects()
        (scheduleServer.shutdown _).expects()
      }

      facade.stopServer()
    }
  }
}
