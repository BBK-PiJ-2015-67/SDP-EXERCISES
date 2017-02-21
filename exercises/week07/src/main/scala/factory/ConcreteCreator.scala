package factory

/**
  * @author lmignot
  */
class ConcreteCreator extends Creator {

    def factory(): Product = new DefaultProduct("Default", 0.0)

    override def factory(productType: String = ""): Product = productType match {
      case _ => factory()
    }

}
