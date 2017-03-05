package test

import java.text.DecimalFormat

import decorator._

/**
  * @author lmignot
  */
class DecoratorSpec extends BaseSpec {
  private val dFormat: DecimalFormat = new DecimalFormat("#.##")

  private val meatCheeseHamNonVegPrice = dFormat.format(403.09)
  private val meatCheeseHamNonVegDesc = "SimplyNonVegPizza, Meat (14.25), Cheese (20.72), Ham (18.12)"

  describe("A decorator") {
    it("should decorate the given class") {
      Given("a pizza")
      val simplePizza: Pizza = new SimplyNonVegPizza()
      When("the pizza is decorated")
      val decoratedPizza: Pizza = new Ham(new Cheese(new Meat(simplePizza)))
      Then("the pizza should have the expected toppings")
      dFormat.format(decoratedPizza.getPrice) should be (meatCheeseHamNonVegPrice)
      decoratedPizza.getDesc should be (meatCheeseHamNonVegDesc)
    }
  }

}
