package mediator

class SoilRemoval {

  def low(): Unit = print("low")

  def medium(): Unit = print("medium")

  def high(): Unit = print("high")

  private def print(level: String): Unit = println(s"Setting Soil Removal to $level")
}