package observer

import scala.collection.mutable.ListBuffer

object TestObserver extends App {
    val obj: CommentaryObject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")
    val observer: SMSUsers = new SMSUsers(obj, "Adam Warner [New York]")
    val observer2: SMSUsers = new SMSUsers(obj, "Tim Ronney [London]")
    observer.subscribe
    observer2.subscribe
    println("-"*40)
    obj.setDesc("Welcome to live Soccer match")
    obj.setDesc("Current score 0-0")
    observer.unSubscribe
    obj.setDesc("It's a goal!!")
    obj.setDesc("Current score 1-0")
}
