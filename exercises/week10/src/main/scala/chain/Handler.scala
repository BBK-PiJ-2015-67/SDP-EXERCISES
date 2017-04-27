package chain

trait Handler {
  /**
    * Set the next [[Handler]] in the chain, and returns this [[Handler]] object
    * to enable method chaining
    *
    * @param handler The next [[Handler]] in this chain of responsibility
    * @return The current object
    */
  def setHandler(handler: Handler): Handler

  /**
    * Process the file, or pass it along to the next [[Handler]] in the chain
    * if one exists. Outputs an error if not
    *
    * @param file The [[File]] to process
    * @return A success or failure message
    */
  def process(file: File): String

  def getHandlerName: String
}
