package singleton

import java.util.UUID

/**
  * Lazy Singleton class
  * @author lmignot
  */
class LazySingleton private extends Singleton {
  private val id: String = UUID.randomUUID.toString
  override def getId: String = id
}

/**
  * LazySingleton concept
  * <p>
  * The private instance is initialised as null
  * and only created when getInstance is called
  */
object LazySingleton {
  private var _instance: Singleton = _

  def getInstance: Singleton = {
    if (_instance == null) _instance = new LazySingleton
    _instance
  }
}