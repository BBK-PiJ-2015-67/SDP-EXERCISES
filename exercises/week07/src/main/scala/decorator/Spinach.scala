package decorator

class Spinach(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  private val price: Double = 7.92

  override def getDesc: String = super.getDesc + s", Cheese ($price)"

  override def getPrice: Double = super.getPrice + price
}
