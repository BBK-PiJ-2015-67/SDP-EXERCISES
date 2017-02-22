package adapter

import adapter.xpay.Xpay

/**
  * Week 07 Exercise 3
  * A simple consumer to test the XpayToPayDAdapter
  * @author lmignot
  */
class PaymentConsumer(gateway: Xpay) {

  def createTransaction(cardNo: String,
                        name: String,
                        month: String,
                        year: String,
                        cvv: Short,
                        amount: Double): Xpay = {
    gateway.setCreditCardNo(cardNo)
    gateway.setCustomerName(name)
    gateway.setCardExpMonth(month)
    gateway.setCardExpYear(year)
    gateway.setCardCVVNo(cvv)
    gateway.setAmount(amount)

    gateway
  }

}
