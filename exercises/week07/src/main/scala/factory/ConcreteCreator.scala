package factory

/**
  * @author lmignot
  */
object ConcreteCreator extends Creator {
    override def apply(p: String = ""): Product = p match {
      case "toy" => Toy("Transformer", 17.67)
      case "food" => Food("Pasta", 1.49)
      case "tool" => Tool("Wrench", 34.99)
      case _ => ConcreteProduct()
    }
}
