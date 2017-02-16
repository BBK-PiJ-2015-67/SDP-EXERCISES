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

  def copy (name: String = this.name,
            yearOfRelease: Int = this.yearOfRelease,
            imdbRating: Double = this.imdbRating,
            director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}

object Film {
  def apply (name: String,
             yearOfRelease: Int,
             imdbRating: Double,
             director: Director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}