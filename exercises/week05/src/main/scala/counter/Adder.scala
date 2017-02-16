package counter

/**
  * An adder provides an add method which adds the value of the adder
  * to the argument and returns the sum
  * @param amount The Adder's value
  */
class Adder(amount: Int) {
  def add(in: Int): Int = in + amount
}
