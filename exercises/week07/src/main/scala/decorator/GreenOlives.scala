package decorator

class GreenOlives(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  private val price: Double = 5.47

  override def getDesc: String = super.getDesc + s", Green olives ($price)"

  override def getPrice: Double = super.getPrice + price
}
