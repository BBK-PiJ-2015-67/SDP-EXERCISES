/**
  * Week 01 Scala exercise 3
  */
object NumberPersonalities {
  val limit = 100

  def main(args: Array[String]): Unit = ???

  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else {
      if (n == 2) true
      else !(2 until n).exists(n % _ == 0)
    }
  }

  def isHappy(n: Int): Boolean = ???

  def isTriangular(n: Int): Boolean = ???

  def isSquare(n: Int): Boolean = ???

  def isSmug(n: Int): Boolean = ???

  def isHonest(n: Int): Boolean = ???

  def isPronic(n: Int): Boolean = ???

  def isDeficient(n: Int): Boolean = ???

  def isPerfect(n: Int): Boolean = ???

  def isAbundant(n: Int): Boolean = ???

  def sumOfPositiveDivisorsOf(n: Int): Int = ???
}
