package films

/**
  * A Film
  * @author lmignot
  */
class Film (val name: String,
            val yearOfRelease: Int,
            val imdbRating: Double,
            val director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy (d: Director): Boolean = d.name == director.name
}
