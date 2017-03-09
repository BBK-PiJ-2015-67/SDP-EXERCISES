package akkanotes.messaging.protocols

object TeacherProtocol {
  case class QuoteRequest()
  case class QuoteResponse(quoteString:String)
}
