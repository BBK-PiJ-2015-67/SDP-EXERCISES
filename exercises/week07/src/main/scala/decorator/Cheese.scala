package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  private val price: Double = 20.72

  override def getDesc: String = super.getDesc + s", Cheese ($price)"

  override def getPrice: Double = super.getPrice + price
}
