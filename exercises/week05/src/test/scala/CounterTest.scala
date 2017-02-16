import org.scalatest.FunSpec
import counter._

class CounterTest extends FunSpec {
  val MinusOne: Int = -1
  val MinusTwo: Int = -2
  val Zero: Int = 0
  val One: Int = 1
  val Two: Int = 2
  val Three: Int = 3
  val Four: Int = 4
  val Five: Int = 5
  val Six: Int = 6
  val Seven: Int = 7
  val Eight: Int = 8
  val Nine: Int = 9
  val Thirteen: Int = 13
  val Fourteen: Int = 14

  describe("A Counter") {
    it(s"should have a default value of $Zero") {
      assert(Counter().count == 0)
    }

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
    it("inc() should accept a value") {
      assert(Counter(One).inc(Five).count == Six)
    }

    it("dec() should accept a value") {
      assert(Counter(Fourteen).dec(Five).count == Nine)
    }

    it(s"inc() should default to $One") {
      assert(Counter(One).inc.count == Two)
    }

    it(s"dec() should default to $One") {
      assert(Counter(Three).dec.count == Two)
    }
  }

}
