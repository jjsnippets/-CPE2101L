package premidsprac;

import java.util.Scanner;

public class Student {
    static int count = 0;
    String fName;
    String lName;
    String age;
    String id;
    Scanner input = new Scanner(System.in);

    public Student() {
        System.out.print("Enter first name: ");
        fName = input.nextLine();
        System.out.print("Enter last name: ");
        lName = input.nextLine();
        System.out.print("Enter age: ");
        age = input.nextLine();
        System.out.print("Enter id: ");
        id = input.nextLine();
        count++;
        System.out.println();
    }

    // debug method
    public void invDisplay() {
        System.out.println("First Name: " + fName);
        System.out.println("Last Name: " + lName);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
    }

    public void rowDisplay() {
        System.out.printf("%-10s %-10s %-10s %-10s\n", fName, lName, age, id);
    }

    // should first use String() to create a copy instead of null-ing out immediately
    // public void removeStudent() {
    //     fName = null;
    //     lName = null;
    //     age = null;
    //     id = null;
    //     count--;
    // }

}
