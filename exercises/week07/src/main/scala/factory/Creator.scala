package factory

/**
  * @author lmignot
  */

trait Creator {
  def getInstance(productType: String): Product
}
