package reflection

import java.lang.reflect.Modifier

import scala.io.StdIn.{readLine => rl}
import scala.reflect.runtime.universe._

/**
  * SDP Scala reflection Exercise 1
  */
object PrintClassSyntax {

  def main(args: Array[String]): Unit = {
    val mirror = runtimeMirror(getClass.getClassLoader)
    val cls = readClass()
    val clsSymbol = mirror.classSymbol(cls)
    val clsType = clsSymbol.toType

//    val methods = cls.getDeclaredMethods
//    val constructors = cls.getDeclaredConstructors
//    val tt = getType(cls)
//    val tpt = getTypeTag(cls.getClass)

    printf("\nClass or Trait?: %s", if (clsSymbol.isTrait) "Trait" else "Class")
    printf("\nModifiers: %s", Modifier.toString(cls.getModifiers))
    println("\nConstructors:")
    val constructors = clsType.members.filter(m => {
      m.isConstructor
    })
    constructors.foreach(c => println(c.name)m/)

//    println("\nDeclarations:")
//    println(tt.decls.mkString("\n"))

//    println("\nConstructors:")
//    constructors.foreach(c => {
//      printf("\t%s\n", c.getName)
//    })

//    println("\nMethods:\n")
//    methods.foreach(m => {
//      println(m.getName)
//    })

  }

  private def readClass (): Class[_] = try {
    Class.forName(rl("Enter the Class or Trait to inspect: "))
  } catch {
    case _: ClassNotFoundException =>
      println("No Class or Trait exists with that name!")
      readClass()
  }

  private def getTypeTag[T: TypeTag] (obj: T) = typeTag[T]

  private def getType[T: TypeTag] (obj: T) = typeOf[T]
}
