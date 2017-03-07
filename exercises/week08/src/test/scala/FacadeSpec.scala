package test
import facadepattern._
import org.mockito.Mockito._

/**
  * Practice using Mockito for testing
  * Testing ScheduleServerFacade, ensuring that the appropriate api methods
  * are called when the simpler api is called
  *
  * @author lmignot
  */
class FacadeSpec extends BaseSpec {

  describe("ScheduleServerFacade") {
    it("should call the required methods when startServer() is called") {
      val scheduleServer = mock[ScheduleServerImpl]

      Given("a ScheduleServerFacade")
      val facade = ScheduleServerFacade(scheduleServer)

      When("startServer() is called")
      facade.startServer()

      Then("the expected methods should have been called on the scheduleServer")
      verify(scheduleServer).startBooting
      verify(scheduleServer).readSystemConfigFile
      verify(scheduleServer).init
      verify(scheduleServer).initializeContext
      verify(scheduleServer).initializeListeners
      verify(scheduleServer).createSystemObjects
      verifyNoMoreInteractions(scheduleServer)
    }

    it("should call the required methods when stopServer() is called") {
      val scheduleServer = mock[ScheduleServerImpl]

      Given("a ScheduleServerFacade")
      val facade = ScheduleServerFacade(scheduleServer)

      When("stopServer() is called")
      facade.stopServer()

      Then("the expected methods should have been called on the scheduleServer")
      verify(scheduleServer).releaseProcesses
      verify(scheduleServer).destroy
      verify(scheduleServer).destroySystemObjects
      verify(scheduleServer).destroyListeners
      verify(scheduleServer).destroyContext
      verify(scheduleServer).shutdown
      verifyNoMoreInteractions(scheduleServer)
    }
  }
}
