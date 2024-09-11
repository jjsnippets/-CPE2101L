package premidsprac;

import java.util.Scanner;

public class phoneBook {
	

	public static void main(String[] args) {
		Student[] lists = new Student[30];
		char choice;
		Scanner input = new Scanner(System.in);

		do {
			choice = displayMenu();

			switch (choice) {
				case '1':
					lists[Student.count] = new Student();
					break;

				// case '2':
				// 	System.out.println("Enter the index of the student you want to remove: ");
				// 	int id = input.nextInt();
				// 	input.nextLine();
				// 	for (int i = 0; i < Student.count; i++) {
				// 		if (lists[i].id == id) {
				// 			lists[i].removeStudent();
				// 			break;
				// 		}
				// 	}
				// 	break;

				case '3':
					System.out.printf("%-10s %-10s %-10s %-10s\n", "First Name", "Last Name", "Age", "ID");
					for (int i = 0; i < Student.count; i++) {
						lists[i].rowDisplay();
					}
					break;
			
			}
		} while (choice != '6');

	}

	public static char displayMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Add a new contact");
		System.out.println("2. Remove a contact");
		System.out.println("3. Display all contacts");
		System.out.println("4. Search for a contact");
		System.out.println("5. Change a contact's details");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
		return input.nextLine().charAt(0);
	}

}
