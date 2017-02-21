package factory

/**
  * @author lmignot
  */
class ConcreteCreator extends Creator {

    override def factory(productType:String): Product = productType match {
      case _ => new DefaultProduct ("Default", 0.0)
    }

}
