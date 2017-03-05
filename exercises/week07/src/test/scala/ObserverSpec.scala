package test
import observer.{CommentaryObject, Observer, SMSUsers}

import scala.collection.mutable.ListBuffer

/**
  * @author lmignot
  */
class ObserverSpec extends BaseSpec {
  describe("Observer/Subject pattern implementation") {

    it("Subject should subscribe observers") {
      Given("A subject")
      val obj: CommentaryObject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")
      And("A subscriber")
      val sub: SMSUsers = new SMSUsers(obj, "John Smith [London]")
      When("We subscribe the observer")
      obj.subscribeObserver(sub)
      Then("The observer should be in the list of subscribers")
      obj.subscribers.contains(sub) should be (true)
    }

    it("Subject should allow observers to subscribe") {
      Given("A subject")
      val obj: CommentaryObject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")
      And("A subscriber")
      val sub: SMSUsers = new SMSUsers(obj, "John Smith [London]")
      When("The observer subscribes")
      sub.subscribe
      Then("The observer should be in the list of subscribers")
      obj.subscribers.contains(sub) should be (true)
    }

    it("Subject should unsubscribe observers") {
      Given("A subject")
      val obj: CommentaryObject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")
      And("A subscriber that is subscribed")
      val sub: SMSUsers = new SMSUsers(obj, "John Smith [London]")
      obj.subscribeObserver(sub)
      When("We unsubscribe the observer")
      obj.unSubscribeObserver(sub)
      Then("The observer should no longer be in the list of subscribers")
      obj.subscribers.contains(sub) should be (false)
    }

    it("Subject should allow observers to unsubscribe") {
      Given("A subject")
      val obj: CommentaryObject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")
      And("A subscriber that is subscribed")
      val sub: SMSUsers = new SMSUsers(obj, "John Smith [London]")
      obj.subscribeObserver(sub)
      When("The observer unsubscribes")
      sub.unSubscribe
      Then("The observer should no longer be in the list of subscribers")
      obj.subscribers.contains(sub) should be (false)
    }

    ignore ("Subject should notify subscribers") {
      Given("A subject")
      val obj: CommentaryObject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")
      And("some observers that subscribe")
      val sub1: SMSUsers = new SMSUsers(obj, "John Smith [London]")
      val sub2: SMSUsers = new SMSUsers(obj, "Adam Warner [New York]")
      sub1.subscribe
      sub2.subscribe
      When("An update is sent")
      obj.setDesc("Welcome to live Soccer match")
      Then("The subscribed observers should receive the update")
      // can't test this cause it returns nothing <roll eyes>
    }

  }
}
