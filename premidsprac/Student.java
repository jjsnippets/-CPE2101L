package premidsprac;

import java.util.Scanner;

public class Student {
    static int count = 0;
    String fName;
    String lName;
    int age;
    int id;
    Scanner input = new Scanner(System.in);

    public Student() {
        System.out.print("Enter first name: ");
        fName = input.nextLine();
        System.out.print("Enter last name: ");
        lName = input.nextLine();
        System.out.print("Enter age: ");
        age = input.nextInt();
        System.out.print("Enter id: ");
        id = input.nextInt();
        input.nextLine();
        count++;
    }

    public void invDisplay() {
        System.out.println("First Name: " + fName);
        System.out.println("Last Name: " + lName);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
    }

    public void rowDisplay() {
        System.out.printf("%-10s %-10s %-10d %-10d\n", fName, lName, age, id);
    }

    public void removeStudent() {
        fName = null;
        lName = null;
        age = 0;
        id = 0;
        count--;
    }

}
