package flyweight

class RubyPlatform extends Platform {

  println("RubyPlatform object created")

  override def execute(code: Code): Unit =
    println(s"Compiling and executing ${code.code}")
}
