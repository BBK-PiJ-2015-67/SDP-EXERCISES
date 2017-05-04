package proxy.virtualproxy

object TestVirtualProxy extends App {
  var contactList: ContactList = new ContactListProxyImpl()
  val company: Company = Company("ABC Company", "Alabama", "011-2845-8965", contactList)
  println(s"Company Name: ${company.companyName}")
  println(s"Company Address: ${company.companyAddress}")
  println(s"Company Contact No.: ${company.companyContactNo}")
  println("Requesting for contact list")
  contactList = company.contactList
  println(contactList.employeeList.mkString("\n"))
}
