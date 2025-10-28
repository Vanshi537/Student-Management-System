package student_management_system;

import java.util.*;

public class ManagementClass {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Input input = new Input();

        // Create scanner to take input
        Scanner sc = new Scanner(System.in);
        int n = input.readPositiveInt(sc, "Enter number of students: ");
        sc.nextLine(); // consume next line

        for (int i = 0; i < n; i++) {
            Student s = input.collectStudentInfo(sc);
            manager.addStudent(s);
        }
        while (true) {
            System.out.println("\n*****Student Management System******");
            System.out.println("1. Display all students");
            System.out.println("2. Update student information");
            System.out.println("3. Delete student");
            System.out.println("4. Search student via ID");
            System.out.println("5. Display students by course");
            System.out.println("6. Display Top Scorer");
            System.out.println("7. Sort students via percentage");
            System.out.println("8. Show total number of students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number (0-8).");
                continue;
            }

            switch (choice) {
                case 1 -> manager.displayAllStudents();
                case 2 -> manager.updateStudent(sc, input);
                case 3 -> manager.deleteStudent(sc, input);
                case 4 -> manager.searchStudent(sc, input);
                case 5 -> manager.displayStudentByCourse(sc, input);
                case 6 -> manager.topScorer();
                case 7 -> manager.sort();
                case 8 -> Student.displayNoOfStudents();
                case 0 -> {
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Wrong input choice!");
            }
        }
    }
}
