package decorator

class Meat(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  private val price: Double = 14.25

  override def getDesc: String = super.getDesc + s", Meat ($price)"

  override def getPrice: Double = super.getPrice + price
}
