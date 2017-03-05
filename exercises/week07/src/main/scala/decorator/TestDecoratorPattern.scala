package decorator

import java.text.DecimalFormat

object TestDecoratorPattern {
  private val dFormat: DecimalFormat = new DecimalFormat("#.##")

  def main(args: Array[String]) {
    var pizza: Pizza = new SimplyVegPizza
    pizza = new RomaTomatoes(pizza)
    print(pizza)
    pizza = new GreenOlives(pizza)
    print(pizza)
    pizza = new Spinach(pizza)
    print(pizza)
    pizza = new SimplyNonVegPizza
    print(pizza)
    pizza = new Meat(pizza)
    print(pizza)
    pizza = new Cheese(pizza)
    print(pizza)
    pizza = new Ham(pizza)
    print(pizza)
  }

  private def print(pizza: Pizza) {
    println("Desc: " + pizza.getDesc)
    println("Price: " + dFormat.format(pizza.getPrice))
  }
}
