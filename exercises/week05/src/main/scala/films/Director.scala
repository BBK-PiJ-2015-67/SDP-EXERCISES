package films

/**
  * A Director
  * @author lmignot
  */
class Director (val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name: String = s"$firstName $lastName"
}
