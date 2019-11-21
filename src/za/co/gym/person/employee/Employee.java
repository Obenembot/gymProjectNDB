package za.co.gym.person.employee;

import za.co.gym.person.person.Person;
import za.co.gym.services.Services;

public class Employee extends Person {

	private String userName;
	private String password;
	private int employeeNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void registerEmployee(String name, String surname, String address, String email, String dateOfBirth,
			long idNumber, long cell, String userName, String password, int employeeNumber) {

		setName(name);
		setSurname(surname);
		setAddress(address);
		setEmail(email);
		setDateOfBirth(dateOfBirth);
		setIdNumber(idNumber);
		setCellNumber(cell);
		setUserName(userName);
		setPassword(password);
		setEmployeeNumber(employeeNumber);
	}

	
	public void display(Services services ) {

		for (int display = 0; display < services.employeeList.size(); display++) {

			System.out.println("Name: " + services.employeeList.get(display).getName());
			System.out.println("Surname: " + services.employeeList.get(display).getSurname());
			System.out.println("Address: " + services.employeeList.get(display).getAddress());
			System.out.println("Email: " + services.employeeList.get(display).getEmail());
			System.out.println("Employee Number: " + services.employeeList.get(display).getEmployeeNumber());
			System.out.println("Date Of Birth: " + services.employeeList.get(display).getDateOfBirth());
			System.out.println("IdNo: " + services.employeeList.get(display).getIdNumber());
			System.out.println("Cell Number: " + services.employeeList.get(display).getCellNumber());
			System.out.println("Username: " + services.employeeList.get(display).getUserName());
			System.out.println("Password: " + services.employeeList.get(display).getPassword());
			System.out.println();
		}

	}

	@Override
	public String toString() {
		return "Employee [userName=" + getUserName() + ", password=" + getPassword() + ", employeeNumber=" + getEmployeeNumber() + " "
				+ super.toString() + "]";
	}

}
