package factory

/**
  * @author lmignot
  */
class ConcreteCreator extends Creator {

    override def getInstance(): Product = new DefaultProduct("Default", 0.0)

    override def getInstance(productType: String = ""): Product = productType match {
      case "toy" => new Toy("Transformer", 15.0)
      case "food" => new Food("Pasta", 2.25)
      case "tool" => new Tool("Wrench", 17.39)
      case _ => getInstance()
    }

}
