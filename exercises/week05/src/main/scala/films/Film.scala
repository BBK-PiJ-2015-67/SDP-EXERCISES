package films

/**
  * A Film
  * @author lmignot
  */
case class Film (name: String,
                 yearOfRelease: Int,
                 imdbRating: Double,
                 director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy (d: Director): Boolean = d.name == director.name
}

object Film {
  def highestRating(f1: Film, f2: Film): Double =
    if (f1.imdbRating > f2.imdbRating) f1.imdbRating else f2.imdbRating

  def oldestDirectorAtTheTime(d1: Film, d2: Film): Director =
    if (d1.directorsAge > d2.directorsAge) d1.director else d2.director
}