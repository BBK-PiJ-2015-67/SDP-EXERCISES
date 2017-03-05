package test
import adapter._
import adapter.xpay.{PayD, PayDImpl, Xpay, XpayImpl}


/**
  * @author lmignot
  */
class AdapterSpec extends BaseSpec {

  final val CardNo = "0987234156782345"
  final val CustName = "Logan"
  final val ExpMonth = "11"
  final val ExpYear = "15"
  final val ExpDate = "11/15"
  final val Cvv: Short = 876
  final val Amt = 98.68

  describe("An adapter") {

    it ("A consumer should work with Xpay interface") {
      Given("An Xpay object")
      val gateway: Xpay = new XpayImpl

      When("A consumer is created that consumes an Xpay object")
      val consumer: PaymentConsumer = new PaymentConsumer(gateway)

      And("A transaction is created for the consumer")
      val transaction = consumer.createTransaction(CardNo, CustName, ExpMonth, ExpYear, Cvv, Amt)

      Then("The transaction should be of the correct type")
      transaction shouldBe a [Xpay]

      And("The transaction should contain the correct data")
      transaction.getAmount should be (Amt)
      transaction.getCustomerName should be (CustName)
      transaction.getCardCVVNo should be (Cvv)
      transaction.getCardExpMonth should be(ExpMonth)
      transaction.getCardExpYear should be(ExpYear)
      transaction.getCreditCardNo should be (CardNo)
    }

    it ("A consumer should also work with XpayToPayDAdaptor") {
      Given("The Xpay adapter containing a PayD interface")
      val payd: PayD = new PayDImpl
      val gateway: Xpay = new XpayToPayDAdapter(payd)

      When("A consumer is created that consumes an Xpay object")
      val consumer: PaymentConsumer = new PaymentConsumer(gateway)

      And("A transaction is created for the consumer")
      val transaction = consumer.createTransaction(CardNo, CustName, ExpMonth, ExpYear, Cvv, Amt)

      Then("The transaction should be of the correct type")
      transaction shouldBe a [Xpay]

      And("The transaction should contain the correct data")
      transaction.getAmount should be (Amt)
      transaction.getCustomerName should be (CustName)
      transaction.getCardCVVNo should be (Cvv)
      transaction.getCardExpMonth should be (ExpMonth)
      transaction.getCardExpYear should be (ExpYear)
      transaction.getCreditCardNo should be (CardNo)
    }

  }

}
