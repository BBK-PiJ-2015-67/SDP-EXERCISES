package adapter
import xpay._

/**
  * Week 07 exercise 3
  * Adapter to convert incompatible interfaces
  * @author lmignot
  */
class XpayToPayDAdapter(gateway: PayD) extends Xpay {

  override def getCreditCardNo: String =
    gateway.getCustCardNo

  override def setCreditCardNo(creditCardNo: String): Unit =
    gateway.setCustCardNo(creditCardNo)

  override def getCustomerName: String =
    gateway.getCardOwnerName

  override def setCustomerName(customerName: String): Unit =
    gateway.setCardOwnerName(customerName)

  override def getCardExpMonth: String = {
    val parts = gateway.getCardExpMonthDate.split('/')
    if (!parts.isEmpty) parts(0) else ""
  }

  override def setCardExpMonth(cardExpMonth: String): Unit =
    gateway.setCardExpMonthDate(cardExpMonth + "/" + getCardExpYear)

  override def getCardExpYear: String = {
    val parts = gateway.getCardExpMonthDate.split('/')
    if (!parts.isEmpty && parts.length == 2) parts(1) else ""
  }

  override def setCardExpYear(cardExpYear: String): Unit =
    gateway.setCardExpMonthDate(getCardExpMonth + "/" + cardExpYear)

  override def getCardCVVNo: Short =
    gateway.getCVVNo.toShort

  override def setCardCVVNo(cardCVVNo: Short): Unit =
    gateway.setCVVNo(cardCVVNo toInt)

  override def getAmount: Double =
    gateway.getTotalAmount

  override def setAmount(amount: Double): Unit =
    gateway.setTotalAmount(amount)
}
