// Adding an object so the compiler doesn't complain
object test {
  println(scala.math.pow(13, 2).toInt)

  def isEven(num: Int): Boolean = (num % 2) == 0
}
