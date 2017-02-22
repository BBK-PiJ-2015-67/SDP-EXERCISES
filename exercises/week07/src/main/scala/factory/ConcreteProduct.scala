package factory

/**
  * @author lmignot
  */
abstract class ConcreteProduct extends Product {

  private var name: String = "Default"
  private var cost: Double = 0.0

  def getCost: Double = cost

  def getName: String = name

  def setCost(c: Double): Unit = cost = c

  def setName(n: String): Unit = name = n

}
