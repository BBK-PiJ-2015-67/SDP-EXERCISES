package decorator

/**
  * @author lmignot
  */
abstract class PizzaDecorator(p: Pizza) extends Pizza {
  override def getDesc: String = p.getDesc

  override def getPrice: Double = p.getPrice
}
