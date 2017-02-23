package factory

/**
  * @author lmignot
  */
class ConcreteCreator extends Creator {

    override def create(): Product = new ConcreteProduct {}

    override def create(productType: String = ""): Product = productType.toLowerCase match {
      case "toy" => new Toy
      case "food" => new Food
      case "tool" => new Tool
      case _ => create()
    }

}
