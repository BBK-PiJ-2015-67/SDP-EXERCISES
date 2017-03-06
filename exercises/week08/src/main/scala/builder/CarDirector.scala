package builder

case class CarDirector(carBuilder: CarBuilder) {
  def build: CarBuilder = {
    carBuilder
      .buildBodyStyle
      .buildEngine
      .buildPower
      .buildFuelType
      .buildBreaks
      .buildSeats
      .buildWindows
  }
}
