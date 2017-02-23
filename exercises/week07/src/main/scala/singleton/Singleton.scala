package singleton

/**
  * Trait defining a Singleton
  * @author lmignot
  */
trait Singleton {
  /**
    * Get the object's UUID
    * When an object is created, a random UUID is generated to prove that the same
    * object is returned every time getInstance is called
    * @return String representing the object's UUID
    */
  def getId: String
}
