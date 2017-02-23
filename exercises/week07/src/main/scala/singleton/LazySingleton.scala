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
  private var _instance: Singleton = _

  def getInstance: Singleton = {
    if (_instance == null) _instance = new LazySingleton
    _instance
  }
}