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

  def highestRating(f1: Film, f2: Film): Double =
    if (f1.imdbRating > f2.imdbRating) f1.imdbRating else f2.imdbRating

  def oldestDirectorAtTheTime(d1: Film, d2: Film): Director =
    if (d1.directorsAge > d2.directorsAge) d1.director else d2.director
}