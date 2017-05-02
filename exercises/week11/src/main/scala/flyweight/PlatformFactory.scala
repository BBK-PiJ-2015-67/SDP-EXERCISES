package flyweight

import scala.collection.immutable.HashMap

object PlatformFactory {

  private var map: Map[String, Platform] = HashMap()

  def getPlatformInstance(platformType: String): Platform = synchronized(map.get(platformType) match {
    case Some(pt) => pt
    case None => platformType match {
      case "SCALA" =>
        map += (platformType -> new ScalaPlatform)
        map(platformType)
      case "JAVA" =>
        map += (platformType -> new JavaPlatform)
        map(platformType)
      case "RUBY" =>
        map += (platformType -> new RubyPlatform)
        map(platformType)
      case "C" =>
        map += (platformType -> new CPlatform)
        map(platformType)
      case _ => throw new NotImplementedError("Platform is not implemented")
    }
  })

}
