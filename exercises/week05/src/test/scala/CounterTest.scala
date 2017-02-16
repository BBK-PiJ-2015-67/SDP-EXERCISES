import org.scalatest.FunSpec

class CounterTest extends FunSpec {
  val MinusOne: Int = -1
  val MinusTwo: Int = -2
  val One: Int = 1
  val Two: Int = 2
  val Thirteen: Int = 13
  val Fourteen: Int = 14

  describe("A Counter") {
    it("inc() should increment the counter") {
      assert(Counter(One).inc.count == Two)
    }

    it("dec() should decrement the counter") {
      assert(Counter(Fourteen).dec.count == Thirteen)
    }

    it("inc() should work with negative values") {
      assert(Counter(MinusTwo).inc.count == MinusOne)
    }

    it("dec() should work with negative values") {
      assert(Counter(MinusOne).dec.count == MinusTwo)
    }
  }
}
