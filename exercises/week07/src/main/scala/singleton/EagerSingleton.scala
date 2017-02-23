package singleton

import java.util.UUID

/**
  * Private Eager Singleton class
  *
  * @author lmignot
  */
class EagerSingleton private extends Singleton {
  private val id: String = UUID.randomUUID.toString
  override def getId: String = id
}

/**
  * Eager Singleton concept
  * <p>
  * The instance is immediately created with the object
  */
object EagerSingleton {
  private val _instance = new EagerSingleton
  def getInstance: Singleton = _instance
}