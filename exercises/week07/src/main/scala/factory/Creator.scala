package factory

/**
  * @author lmignot
  */

trait Creator {
  def apply(product: String): Product
}
