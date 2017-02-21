package factory

/**
  * @author lmignot
  */
abstract class ConcreteProduct(val name: String, val cost: Double) extends Product {

  def getCost: Double = cost

  def getName: String = name

}
