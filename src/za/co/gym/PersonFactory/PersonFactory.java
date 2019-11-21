package za.co.gym.PersonFactory;

import za.co.gym.person.customer.Customer;
import za.co.gym.person.employee.Employee;
import za.co.gym.person.person.Person;

public class PersonFactory {

	
	
	public static Person createPerson(String person) {
		return person.equalsIgnoreCase("Employee") ? new Employee() : person.equalsIgnoreCase("Customer") ?
				new Customer() : null;

	}
	
}
