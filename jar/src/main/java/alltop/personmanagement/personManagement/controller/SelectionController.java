package alltop.personmanagement.personManagement.controller;

import java.util.Scanner;

public class SelectionController {

	public int sortOptions() {
		System.out.println("How would you like to sort the given data?");
		System.out.println("Output 1 – sorted by gender (females before males) then by last name ascending.");
		System.out.println("Output 2 – sorted by birth date, ascending.");
		System.out.println("Output 3 – sorted by last name, descending.");
		int choice = -1;
		Scanner keyboard = new Scanner(System.in);
		while (choice == -1) {

			if (keyboard.hasNextInt()) {
				choice = checkValidSelection(keyboard.nextInt(), keyboard);
			} else {
				System.out.println("Please enter 1, 2, or 3");
				keyboard.nextLine();
			}

		}
		keyboard.close();
		return choice;
	}

	private int checkValidSelection(int i, Scanner keyboard) {
		switch (i) {
		case 1:
		case 2:
		case 3:
			return i;
		default:
			System.out.println("Please enter 1, 2, or 3");
			keyboard.nextLine();
			return -1;
		}
	}
}
