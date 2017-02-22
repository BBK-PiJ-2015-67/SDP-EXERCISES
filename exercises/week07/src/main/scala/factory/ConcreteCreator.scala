package factory

/**
  * @author lmignot
  */
class ConcreteCreator extends Creator {

    override def getInstance(): Product = new ConcreteProduct {}

    override def getInstance(productType: String = ""): Product = productType.toLowerCase match {
      case "toy" => new Toy
      case "food" => new Food
      case "tool" => new Tool
      case _ => getInstance()
    }

}
