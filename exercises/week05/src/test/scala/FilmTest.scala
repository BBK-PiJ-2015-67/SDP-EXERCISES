import org.scalatest.FunSpec
import films._

/**
  * @author lmignot
  */
class FilmTest extends FunSpec {
  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someGuy = new Director("Just", "Some Guy", 1990)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)

  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  describe("A Director") {
    it("should have the correct date of birth") {
      assert(eastwood.yearOfBirth == 1930)
    }

    it("should have the correct full name") {
      assert(eastwood.name == "Clint Eastwood")
    }

    it("apply() should return a new director") {
      val ec = Director("Clint", "Eastwood", 1930)
      assert(ec.name == "Clint Eastwood")
      assert(ec.yearOfBirth == 1930)
    }

    it("older() should return the oldest of 2 directors") {
      val d1 = Director("John", "Doe", 1972)
      val d2 = Director("Christopher", "Nolan", 1970)
      val eldest = Director.older(d1, d2)
      assert(eldest.name == d2.name)
      assert(eldest.yearOfBirth == d2.yearOfBirth)
    }
  }

  describe("A Film") {
    it("should have the correct director") {
      assert(dieHard.director.name == "John McTiernan")
    }

    it("isDirectedBy() should return if a film is directed by the provided director") {
      assert(!invictus.isDirectedBy(nolan))
    }

    it("copy() should return an appropriately modified (or not) copy") {
      val hpCopy = highPlainsDrifter.copy(name = "L’homme des hautes plaines")
      val tcCopy = thomasCrownAffair.copy(yearOfRelease = 1968,
        director = new Director("Norman", "Jewison", 1926))
      assert(hpCopy.yearOfRelease == highPlainsDrifter.yearOfRelease)
      assert(hpCopy.imdbRating == highPlainsDrifter.imdbRating)
      assert(hpCopy.director.name == highPlainsDrifter.director.name)
      assert(tcCopy.yearOfRelease != thomasCrownAffair.yearOfRelease)
      assert(tcCopy.director.name != thomasCrownAffair.director.name)
      assert(tcCopy.imdbRating == thomasCrownAffair.imdbRating)
    }

    it("apply() should return a new film") {
      val gt = Film("Gran Torino", 2008, 8.2, eastwood)
      assert(gt.name == granTorino.name)
      assert(gt.yearOfRelease == granTorino.yearOfRelease)
      assert(gt.imdbRating == granTorino.imdbRating)
      assert(gt.director.name == granTorino.director.name)
    }
  }
}
