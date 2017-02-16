package counter

/**
  * counter.Counter class for Week 5 - exercise 1
  * @author lmignot
  */
class Counter (n: Int) {

  /**
    * Return a new counter.Counter with the value of this counter.Counter incremented by one
    * @return The new counter.Counter with an incremented value
    */
  def inc: Counter = new Counter(n + 1)

  /**
    * Return a new counter.Counter with the value of this counter.Counter decremented by one
    * @return The new counter.Counter with a decremented value
    */
  def dec: Counter = new Counter(n - 1)

  /**
    * Retrieve the value of this counter.Counter
    * @return an Int containing the value of this counter.Counter
    */
  def count: Int = n
}
