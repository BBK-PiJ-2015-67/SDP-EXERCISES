package bridge

case class BigWheel(product: Product, s: String) extends Car (product, s) {

  override def assemble: String = {
    val result: String = s"${super.assemble} for $s"
    println(result)
    result
  }

  override def produceProduct: String = {
    super.produceProduct
    val result: String = s"Modifying product ${product.productName} according to $s"
    println(result)
    result
  }

  override def printDetails: String = {
    val result: String = s"Car: $s, Product: ${product.productName}"
    println(result)
    result
  }
}
