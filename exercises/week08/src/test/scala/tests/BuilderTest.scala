package tests

import builder.{CarDirector, SedanCarBuilder, SportsCarBuilder}

/**
  * @author lmignot
  */
class BuilderTest extends BaseTest {
  describe("Sedan car builder") {
    it("should build a sedan car") {
      val carBuilder = SedanCarBuilder
      val director = CarDirector(carBuilder)

      val car = director.build.getCar

      car.getBodyStyle should not be null
      car.getEngine should not be null
      car.getPower should not be null
      car.getFuelType should not be null
      car.getBreaks should not be null
      car.getSeats should not be null
      car.getWindows should not be null

      car.carType should be ("SEDAN")
    }
  }
  describe("Sports car builder") {
    it("should build a sedan car") {
      val carBuilder = SportsCarBuilder
      val director = CarDirector(carBuilder)

      val car = director.build.getCar

      car.getBodyStyle should not be null
      car.getEngine should not be null
      car.getPower should not be null
      car.getFuelType should not be null
      car.getBreaks should not be null
      car.getSeats should not be null
      car.getWindows should not be null

      car.carType should be ("SPORTS")
    }
  }
}
