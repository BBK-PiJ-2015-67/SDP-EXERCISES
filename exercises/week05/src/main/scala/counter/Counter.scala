package counter

/**
  * Counter class for Week 5 - exercise 1
  * @author lmignot
  */
class Counter (private val n: Int) {

  /**
    * Return a new Counter with the value of this Counter incremented by the
    * provided value which defaults to 1
    * @param x: Int The optional value to increment the Counter by
    * @return The new Counter with an incremented value
    */
  def inc (x: Int = 1): Counter = new Counter(n + x)

  /**
    * Return a new Counter with the value of this Counter incremented by one
    * @return The new Counter with an incremented value
    */
  def inc: Counter = inc()

  /**
    * Return a new Counter with the value of this Counter decremented by
    * the provided value which defaults to 1
    * @param x: Int The optional value to decrement the Counter by
    * @return The new Counter with a decremented value
    */
  def dec (x: Int = 1): Counter = new Counter(n - x)

  /**
    * Return a new Counter with the value of this Counter decremented by one
    * @return The new Counter with a decremented value
    */
  def dec: Counter = dec()

  /**
    * Retrieve the value of this Counter
    * @return an Int containing the value of this Counter
    */
  def count: Int = n
}
