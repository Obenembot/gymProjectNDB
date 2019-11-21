package za.co.gym.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import za.co.gym.PersonFactory.PersonFactory;
import za.co.gym.payment.Payment;
import za.co.gym.person.customer.Customer;
import za.co.gym.person.employee.Employee;
import za.co.gym.person.person.Person;
import za.co.gym.services.Services;

public class Application {

	public static void main(String[] args) {		
		
		Scanner scanner = new Scanner(System.in);
		Services services = new Services();
		Person person = null;
		Payment payment = null;
		
		services.services.put(1, "One Month Package = R200");
		services.services.put(2, "Two Month Package = R400");
		services.services.put(3, "Three Month Package = R600");

		// List<Person> personList = new ArrayList<Person>();

		int registerWho = 0; // who to register takes an int type.
		String whoToRegister = null; // the registerWho is letter Transform to String and finally to the factory.
		int c = 0;
		int employeeNumber = 1001;
		int display = 0;
		int memberShipNumber = 1001;
		
		do {
			dol: for (int a = 0; a < 2; a++) { // general Loop.....

				payment = new Payment();
				
				System.out.println();
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Who do you want to register? ");
				System.out.println(" 1. for employee and" + " 2. for Customer ");
				System.out.println("Press 3. to extend");
				System.out.println("to Display Details Employee press 4. and 5. for Customer");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				try {
					registerWho = scanner.nextInt();
				} catch (Exception ex) {
					System.out.println("wrong input");
				}

				if (registerWho == 1) {
					whoToRegister = "employee";
				} else if (registerWho == 2) {
					whoToRegister = "Customer";
				} else if (registerWho == 3) {
					for (Integer key : services.services.keySet()) {
						String value = services.services.get(key);

						System.out.println(key + " " + value);
					}
					
					System.out.println("Enter memberShipNumber");
					int  checkMemberShipNumber = scanner.nextInt();
					System.out.println("Enter selectPackage ");
					int selectPackage = scanner.nextInt();
					services.extendDuration(checkMemberShipNumber, selectPackage);

					break dol;
				}
				person = PersonFactory.createPerson(whoToRegister);

				if (registerWho == 4) {
					for(Employee ee : services.employeeList){
						System.out.println(ee);
					}
					//((Employee) person).display(services); // displaying employee object....
					break dol;
				} else if (registerWho == 5) {
					
					for(Customer cc : services.customerList) {
						System.out.println(cc);
					}
					//((Customer) person).display(services); // display for Customer
					
					
					break dol;
				}

				scanner.nextLine();
				System.out.println();
				System.out.println("	Enter Details Here");
				System.out.println("................................");
				System.out.println("Enter Name");
				String name = scanner.nextLine();
				System.out.println("Enter Surname");
				String surname = scanner.nextLine();
				System.out.println("Enter address");
				String address = scanner.nextLine();
				System.out.println("Enter Email");
				String email = scanner.nextLine();
				System.out.println("Enter Date of Birth");
				String dateOfBirth = scanner.nextLine();
				long idNumber = 0;
				long cellNumber = 0;
				int year = 0;
				int month = 0;
				int day = 0;
				int duration = 0;

				try {
					System.out.println("Enter IdNumber");
					idNumber = scanner.nextLong();

				} catch (Exception ex) {
					System.out.println("wrong input");
				}

				try {
					System.out.println("Enter Cell Number");
					cellNumber = scanner.nextLong();

				} catch (Exception ex) {
					System.out.println("wrong input");
				}
				if (registerWho == 1) {
					scanner.nextLine();
					System.out.println("Enter Username");
					String userName = scanner.nextLine();
					System.out.println("Enter password");
					String password = scanner.nextLine();
					System.out.println("Enter");

					employeeNumber++;
					// employee method been cast to Employee becasue of the Person Type.....
					((Employee) person).registerEmployee(name, surname, address, email, dateOfBirth, idNumber,
							cellNumber, userName, password, employeeNumber);

					services.employeeList.add((Employee) person); // adding new Employees.

				} else if (registerWho == 2) { // only for Customer. here Customer related
					try {
						System.out.println("Enter Started Date(year in fig)");
						year = scanner.nextInt();
					} catch (Exception ex) {
						System.out.println("wrong input");
					}
					try {
						System.out.println("Enter Month (in fig)");
						month = scanner.nextInt();
					} catch (Exception ex) {
						System.out.println("wrong input");
					}

					try {
						System.out.println("Enter Day(in fig)");
						day = scanner.nextInt();
					} catch (Exception ex) {
						System.out.println("wrong input");
					}
					LocalDate startedDate = LocalDate.of(year, month, day);

					scanner.nextLine();
					try {
						System.out.println("Enter Duration; Minimum of 1 month and Maximum of 3 months");

						for (Integer key : services.services.keySet()) {
							String value = services.services.get(key);

							System.out.println(key + " " + value);
						}
						duration = scanner.nextInt();

					} catch (Exception ex) {
						System.out.println("wrong input");
					}

					((Customer) person).registerCustomer(name, surname, address, email, dateOfBirth, idNumber,
							cellNumber, startedDate, duration, memberShipNumber);// this line signifying the Customer
																					// registration

					double amount = 0;
					scanner.nextLine();
					System.out.println("proceed to payment ? (y/n)");
					String proceedToPayment = scanner.nextLine();
					if (proceedToPayment.equalsIgnoreCase("y")) {
						// here, the selected payment me
						try {
							scanner.nextLine();
							System.out.println("Enter Amount");
							amount = scanner.nextDouble();
						} catch (Exception ex) {
							System.out.println("wrong input");
						}
						System.out.println("Balance is " + payment.cashPayment(amount, duration)); // setting
																									// CashPayment
						memberShipNumber++; // method.
					}

					services.customerList.add((Customer) person);// adding registration for Customer

				} // end of Customer Registration

			} // end of general loop..

		} while (c < 5);
		/*
		 * Predicate< Person> personPredicate = new Predicate<Person>() {
		 * GregorianCalendar currentDate = new GregorianCalendar();
		 * 
		 * @Override public boolean test(Person t) { // TODO Auto-generated method stub
		 * if( currentDate.after(((Customer) t).getEndDate()) ); return true; } };
		 */

	}

}
