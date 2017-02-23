package singleton

import java.util.UUID

/**
  * @author lmignot
  */
class LazySingleton private extends Singleton {
  private val id: String = UUID.randomUUID.toString
  override def getId: String = id
}

object LazySingleton {
  private lazy val _instance = new LazySingleton
  def getInstance: Singleton = _instance
}