package proxy.virtualproxy

case class Employee(
  employeeName: String,
  employeeSalary: Double,
  employeeDesignation: String
) {

  override def toString: String =
    s"EmployeeName: $employeeName, " +
    s"EmployeeDesignation: $employeeDesignation, " +
    s"EmployeeSalary: $employeeSalary"
}
