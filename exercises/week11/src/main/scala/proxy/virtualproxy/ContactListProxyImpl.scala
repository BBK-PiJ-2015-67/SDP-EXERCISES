package proxy.virtualproxy

class ContactListProxyImpl extends ContactList {

  private lazy val contactList: ContactList = ContactListImpl()

  override def employeeList: Vector[Employee] = contactList.employeeList

}
