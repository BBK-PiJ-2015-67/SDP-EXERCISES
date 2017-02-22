package adapter.xpay

/**
  * Week 07 exercise 3
  * Quick implementation of PayD
  * @author lmignot
  */
class PayDImpl extends PayD {
  private var creditCardNo = None: Option[String]
  private var customerName = None: Option[String]
  private var cardExpDate = None: Option[String]
  private var cardCVVNo: Integer = 0
  private var amount: Double = .0

  override def getCustCardNo: String = creditCardNo.getOrElse("")

  override def setCustCardNo(custCardNo: String): Unit = creditCardNo = Some(custCardNo)

  override def getCardOwnerName: String = customerName.getOrElse("")

  override def setCardOwnerName(cardOwnerName: String): Unit = customerName = Some(cardOwnerName)

  override def getCardExpMonthDate: String = cardExpDate.getOrElse("/")

  override def setCardExpMonthDate(cardExpMonthDate: String): Unit = cardExpDate = Some(cardExpMonthDate)

  override def getCVVNo: Integer = cardCVVNo

  override def setCVVNo(cVVNo: Integer): Unit = cardCVVNo = cVVNo

  override def getTotalAmount: Double = amount

  override def setTotalAmount(totalAmount: Double): Unit = amount = totalAmount
}
