
package student_management_system;

import java.util.Scanner;

public class Input {

    // Helper method to read an integer safely
    public int readInt(Scanner sc, String prompt) {
        int num;
        while (true) {
            System.out.print(prompt);
            try {
                num = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        return num;
    }

    // Helper method to read a positive integer
    public int readPositiveInt(Scanner sc, String prompt) {
        int num;
        while (true) {
            num = readInt(sc, prompt);
            if (num > 0)
                break;
            System.out.println("Please enter a positive number!");
        }
        return num;
    }

    // Helper method to read a double safely
    public double readDouble(Scanner sc, String prompt) {
        double num;
        while (true) {
            System.out.print(prompt);
            try {
                num = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        return num;
    }

    // Helper method to read percentage (0-100)
    public double readPercentage(Scanner sc, String prompt) {
        double num;
        while (true) {
            num = readDouble(sc, prompt);
            if (num >= 0 && num <= 100)
                break;
            System.out.println("Percentage must be between 0 and 100!");
        }
        return num;
    }

    // Helper method to read a non-empty string
    public String readNonEmptyString(Scanner sc, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.isEmpty())
                break;
            System.out.println("Input cannot be empty!");
        }
        return input;
    }

    // Helper method to read 10-digit contact number
    public String readContactNumber(Scanner sc, String prompt) {
        String contact;
        while (true) {
            contact = readNonEmptyString(sc, prompt);
            if (contact.matches("\\d{10}"))
                break;
            System.out.println("Enter a valid 10-digit number!");
        }
        return contact;
    }

    // Helper method to read blood group
    public String readBloodGroup(Scanner sc, String prompt) {
        String bg;
        while (true) {
            bg = readNonEmptyString(sc, prompt).toUpperCase();
            if (bg.matches("A\\+|A\\-|B\\+|B\\-|AB\\+|AB\\-|O\\+|O\\-"))
                break;
            System.out.println("Enter a valid blood group (A+, B-, O+, etc.)");
        }
        return bg;
    }

    // Main method to collect all student info safely
    public Student collectStudentInfo(Scanner sc) {
        System.out.println("\nEnter details for student:");

        int id = readPositiveInt(sc, "Id: ");
        String name = readNonEmptyString(sc, "Name: ");
        int age = readPositiveInt(sc, "Age: ");
        int rollNo = readPositiveInt(sc, "Roll Number: ");
        String course = readNonEmptyString(sc, "Course: ");
        String bloodGroup = readBloodGroup(sc, "Blood Group: ");
        String fatherName = readNonEmptyString(sc, "Father's Name: ");
        String address = readNonEmptyString(sc, "Address: ");
        String contactNo = readContactNumber(sc, "Contact Number: ");
        String parentContactNo = readContactNumber(sc, "Parent's Contact Number: ");
        double percent = readPercentage(sc, "Percentage: ");

        // Use Builder pattern
        Student student = new Student.Builder()
                .setId(id)
                .setName(name)
                .setAge(age)
                .setRollNo(rollNo)
                .setCourse(course)
                .setBloodGroup(bloodGroup)
                .setFatherName(fatherName)
                .setAddress(address)
                .setContactNo(contactNo)
                .setParentContactNo(parentContactNo)
                .setPercentage(percent)
                .build();

        return student;
    }
}
