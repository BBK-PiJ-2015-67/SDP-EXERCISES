package akkanotes.messaging.protocols

/**
  * @author Arun Manivannan
  */
object TeacherProtocol {
  case class QuoteRequest()
  case class QuoteResponse(quoteString:String)
}
