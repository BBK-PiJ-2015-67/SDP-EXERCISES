package factory

/**
  * @author lmignot
  */
abstract class ConcreteProduct(var name: String, var cost: Double) extends Product {

  def getCost: Double = cost

  def getName: String = name

  def setCost(c: Double): Unit = cost = c

  def setName(n: String): Unit = name = n

}
