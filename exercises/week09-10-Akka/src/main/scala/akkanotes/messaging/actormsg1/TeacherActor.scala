package akkanotes.messaging.actormsg1

import akka.actor.Actor
import akkanotes.messaging.protocols.TeacherProtocol.{QuoteRequest, QuoteResponse}

/**
  * @author Arun Manivannan
  */
class TeacherActor extends Actor {

  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {

    case QuoteRequest =>

      import util.Random

      //Get a random Quote from the list and construct a response
      val quoteResponse=QuoteResponse(quotes(Random.nextInt(quotes.size)))

      println (quoteResponse)

  }

}
