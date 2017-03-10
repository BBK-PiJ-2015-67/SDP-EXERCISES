package bridge

case class GearLocking(s: String) extends Product {

  override def productName: String = s

  override def produce: String = {
    val result: String = s"Producing $s System"
    println(result)
    result
  }
}
