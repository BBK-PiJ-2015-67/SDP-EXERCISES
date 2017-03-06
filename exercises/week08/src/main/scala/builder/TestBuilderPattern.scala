package builder

object TestBuilderPattern {
  def main(args: Array[String]) {
    var carBuilder: CarBuilder = SedanCarBuilder
    var director: CarDirector = CarDirector(carBuilder)

    println(director.build.getCar)

    carBuilder = SportsCarBuilder
    director = CarDirector(carBuilder)

    println(director.build.getCar)
  }
}
