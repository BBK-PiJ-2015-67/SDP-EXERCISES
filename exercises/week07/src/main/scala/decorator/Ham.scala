package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  private val price: Double = 18.12

  override def getDesc: String = super.getDesc + s", Ham ($price)"

  override def getPrice: Double = super.getPrice + price
}
