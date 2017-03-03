package factory

/**
  * @author lmignot
  */
trait Product {
  val name: String
  val cost: Double
}

case class ConcreteProduct(name: String = "Default", cost: Double = 0.0) extends Product
case class Food(name: String, cost: Double) extends Product
case class Toy(name: String, cost: Double) extends Product
case class Tool(name: String, cost: Double) extends Product
