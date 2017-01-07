package pojos;

public class Employee {
	String empId;
	String empName;
	String password;
	String department;
	String role;

	public Employee(String empName) {
		this.empName = empName;	
	}
	
	public Employee(String empId, String empName, String password, String department, String role) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.department = department;
		this.role = role;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", password=" + password + ", department="
				+ department + ", role=" + role + "]";
	}


}
