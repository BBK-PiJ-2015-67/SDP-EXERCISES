package factory

/**
  * @author lmignot
  */

trait Creator {
  def create(): Product
  def create(productType: String): Product
}
