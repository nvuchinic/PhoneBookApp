package ba.bitcamp.lab.PhoneBook;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * class for representing simple phonebook application.It uses hashmap data
 * structure for storing data.
 * 
 * @author nermin.vucinic
 * 
 */
public class PhoneBookApp_v3 {
	static int input;
	static HashMap<String, LinkedList<String>> phoneBookMap = new HashMap<String, LinkedList<String>>();
	static Set<String> keys = phoneBookMap.keySet();
	static Scanner in = new Scanner(System.in);

	/**
	 * adds new contact to the phonebook
	 */
	public static void addContact() {
		System.out.println("Enter the name:");
		String name = in.nextLine();
		phoneBookMap.put(name, new LinkedList<String>());
		System.out.println("Enter the number:");
		String number = in.nextLine();
		phoneBookMap.get(name).push(number);
	}

	/**
	 * edits the existing contact(adds the new number) in the phonebook
	 */
	public static void editContact() {
		System.out.println("Enter the contact name you want to add number to:");
		String contact = in.nextLine();
		while (!keys.contains(contact)) {
			System.out
					.println("There is no such contact in phonebook!Try again:");
		}
		System.out.println("Enter the number:");
		String newNumber = in.nextLine();
		phoneBookMap.get(contact).add(newNumber);
	}

	/**
	 * removes the selected contact from phonebook
	 */
	public static void deleteContact() {
		System.out.println("Enter the name of contact you want to delete:");
		String contact = in.nextLine();
		while (!keys.contains(contact)) {
			System.out
					.println("There is no such contact in phonebook!Try again:");
			contact = in.nextLine();

		}
		phoneBookMap.remove(contact);
	}

	/**
	 * lists all the existing contacts(all data in the HashMap object)
	 */
	public static void listContacts() {
		System.out.println("\n\nPHONEBOOK LIST:\n_____________________");
		if (phoneBookMap.isEmpty()) {
			System.out.println("\nPhonebook is empty!\n_________________________");
		} else {
			Iterator<String> keyIterator = keys.iterator();
			int j = 0;
			while (keyIterator.hasNext()) {
				++j;
				int i = 0;
				String key = keyIterator.next();
				Iterator<String> valueIterator = phoneBookMap.get(key)
						.iterator();
				System.out.println("Entry no " + j + "\n\tName: " + key);
				while (valueIterator.hasNext()) {
					++i;
					System.out.print("\tPhone number " + i + ": "
							+ valueIterator.next());
				}
				System.out.println("\n___________________________ ");
			}
		}
	}

	/**
	 * displays main menu for user to choose from in console
	 */
	public static void showMenu() {
		System.out
				.println("Choose option:\nPush 1 if you want to add new contact \nPush 2 if you want to edit the contact"
						+ "\nPush 3 if you want to delete the contact\nPush 4 if you want to list contacts"
						+ "\nPush -1 for exit");
	}

	/**
	 * runs the application
	 */
	public static void startApp() {
		input = in.nextInt();
		while (input != -1) {
			switch (input) {
			case 1:
				addContact();
				break;
			case 2:
				editContact();
				break;
			case 3:
				deleteContact();
				break;
			case 4:
				listContacts();
				break;

			}
			showMenu();
			input = in.nextInt();

		}
	}

	public static void main(String[] args) {

		showMenu();
		startApp();

	}
}
