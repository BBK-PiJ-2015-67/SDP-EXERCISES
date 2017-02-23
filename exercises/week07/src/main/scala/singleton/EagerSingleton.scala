package singleton

import java.util.UUID

/**
  * @author lmignot
  */
class EagerSingleton private extends Singleton {
  private val id: String = UUID.randomUUID.toString
  override def getId: String = id
}

object EagerSingleton {
  private val _instance = new EagerSingleton
  def getInstance: Singleton = _instance
}