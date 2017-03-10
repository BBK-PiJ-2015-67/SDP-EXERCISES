package bridge

abstract class Car(product: Product, carType: String) {

  def assemble: String = s"Assembling ${product.productName}"

  def produceProduct: String = {
    val result: String = s"Producing ${product.productName}"
    println(result)
    result
  }

  def printDetails: String
}
