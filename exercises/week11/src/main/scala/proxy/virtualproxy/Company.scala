package proxy.virtualproxy

case class Company(
  companyName: String,
  companyAddress: String,
  companyContactNo: String,
  contactList: ContactList
) {
  println("Company object created...")
}
