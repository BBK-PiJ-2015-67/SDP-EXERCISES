package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  private val price: Double = 5.20

  override def getDesc: String = super.getDesc + s", Roma Tomatoes ($price)"

  override def getPrice: Double = super.getPrice + price
}
