package factory

/**
  * @author lmignot
  */

trait Creator {
  def getInstance(): Product
  def getInstance(productType: String): Product
}
