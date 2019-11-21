package za.co.gym.services;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import za.co.gym.person.customer.Customer;
import za.co.gym.person.employee.Employee;

public class Services {

	public List<Employee> employeeList = new ArrayList<Employee>();

	public List<Customer> customerList = new ArrayList<Customer>();

	LocalDate currentDate = LocalDate.now();

	public static Map<Integer, String> services = new HashMap<Integer, String>();

	public void extendDuration(int memberShipNumber, int selectedPackage) {

		for (int a = 0; a < customerList.size(); a++) {

			if (memberShipNumber == customerList.get(a).getMemberShipNumber()) {
				if (customerList.get(a).getEndDate().isBefore(currentDate)) {

					customerList.get(a).setDuration(customerList.get(a).getDuration() + selectedPackage);// to add
																											// duration
					currentDate.getMonth().plus(selectedPackage); // for memberShip number
					customerList.get(a).setEndDate(currentDate); // to set The endDate
				} else {
					System.out.println("Date is not Before Current Date: " + customerList.get(a).getEndDate());
				}
			}
		}
	}

}
