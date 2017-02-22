package factory

/**
  * @author lmignot
  */
trait Product {
  def getName: String
  def getCost: Double
  def setName(n: String): Unit
  def setCost(c: Double): Unit
}
