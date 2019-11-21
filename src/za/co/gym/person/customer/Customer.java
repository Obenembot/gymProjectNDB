package za.co.gym.person.customer;

import java.time.LocalDate;
import java.util.function.Consumer;

import za.co.gym.person.person.Person;
import za.co.gym.services.Services;

public class Customer extends Person {
	private LocalDate startDate;
	private LocalDate endDate;

	private int memberShipNumber;
	private int duration;

	public int getMemberShipNumber() {
		return memberShipNumber;
	}

	public void setMemberShipNumber(int memberShipNumber) {
		this.memberShipNumber = memberShipNumber;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Customer [startDate=" + startDate + ", endDate=" + endDate + ", memberShipNumber=" + memberShipNumber
				+ ", duration=" + duration + super.toString() + "]";
	}

	public void registerCustomer(String name, String surname, String address, String email, String dateOfBirth,
			long idNumber, long cellNumber, LocalDate startDate, int duration, int memberShipNumber) {
		// Customer customer = new Customer();

		setName(name);
		setSurname(surname);
		setAddress(address);
		setEmail(email);
		setDateOfBirth(dateOfBirth);
		setIdNumber(idNumber);
		setCellNumber(cellNumber);
		setDuration(duration);
		setStartDate(startDate);
		setMemberShipNumber(memberShipNumber);

		LocalDate endDate = LocalDate.of(getStartDate().getYear(), getStartDate().getMonth().plus(duration),
				getStartDate().getDayOfMonth());

		setEndDate(endDate);

		System.out.println("Started Date " + getStartDate());
		System.out.println("End Date " + getEndDate());

	}

	/*
	 * public static Consumer<Customer> customerDisplay = new Consumer<Customer>() {
	 * 
	 * @Override public void accept(Customer t) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * };
	 */
	
	

	public void display(Services services) {
		for (int display = 0; display < services.customerList.size(); display++) {
			System.out.println();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println();
			System.out.println("Name: " + services.customerList.get(display).getName());
			System.out.println("Surname: " + services.customerList.get(display).getSurname());
			System.out.println("Address: " + services.customerList.get(display).getAddress());
			System.out.println("Email: " + services.customerList.get(display).getEmail());
			System.out.println("MemberShip Number: " + services.customerList.get(display).getMemberShipNumber());
			System.out.println("Date Of Birth: " + services.customerList.get(display).getDateOfBirth());
			System.out.println("IdNo: " + services.customerList.get(display).getIdNumber());
			System.out.println("Cell Number: " + services.customerList.get(display).getCellNumber());
			System.out.println("Duration: " + services.customerList.get(display).getDuration());
			System.out.println("Start Date: " + services.customerList.get(display).getStartDate());
			System.out.println("End Date : " + services.customerList.get(display).getEndDate());
			System.out.println("...................................................................");
		}

	}
	
	

}
