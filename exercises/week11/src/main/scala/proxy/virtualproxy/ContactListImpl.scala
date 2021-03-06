package proxy.virtualproxy

case class ContactListImpl() extends ContactList {

  private lazy val employees = Vector(
    Employee("Employee A", 2565.55, "SE"),
    Employee("Employee B", 22574.00, "Manager"),
    Employee("Employee C", 3256.77, "SSE"),
    Employee("Employee D", 4875.54, "SSE"),
    Employee("Employee E", 2847.01, "SE")
  )

  override def employeeList: Vector[Employee] = employees
}
