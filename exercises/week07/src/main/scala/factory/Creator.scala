package factory

/**
  * @author lmignot
  */

trait Creator {
  def factory(productType: String): Product
}
