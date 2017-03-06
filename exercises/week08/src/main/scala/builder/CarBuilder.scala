package builder

trait CarBuilder {
  def buildBodyStyle: CarBuilder

  def buildPower: CarBuilder

  def buildEngine: CarBuilder

  def buildBreaks: CarBuilder

  def buildSeats: CarBuilder

  def buildWindows: CarBuilder

  def buildFuelType: CarBuilder

  def getCar: Car
}