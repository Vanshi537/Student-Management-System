package student_management_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManager {
    // Create ArrayList to store student objects
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayAllStudents() {
        for (Student s : students) {
            s.displayStudentInfo();
        }
        if (students.isEmpty()) {
            System.out.println("No students to display!");
            return;
        }
    }

    public void updateStudent(Scanner sc, Input input) {
        int searchID = input.readPositiveInt(sc, "Enter the ID of the student you want to update: ");
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == searchID) {
                found = true;
                System.out.println("\nStudent found!");
                s.displayStudentInfo();
                System.out.println("\nWhich field do you want to change?");
                System.out.println("1: Name");
                System.out.println("2: Age");
                System.out.println("3: Blood Group");
                System.out.println("4: Course");
                System.out.println("5: Father's Name");
                System.out.println("6: Contact Number");
                System.out.println("7: Parent's Contact Number");
                System.out.println("8: Address");
                System.out.println("9: Percentage");
                System.out.println("Enter 0 to exit");

                int change;
                do {
                    change = input.readInt(sc, "\nEnter your choice: ");
                    switch (change) {
                        case 1 -> {
                            String newName = input.readNonEmptyString(sc, "Enter new Name: ");
                            s.setName(newName);
                            System.out.println("Name updated successfully!");
                        }
                        case 2 -> {
                            int newAge = input.readPositiveInt(sc, "Enter new Age: ");
                            s.setAge(newAge);
                            System.out.println("Age updated successfully!");
                        }
                        case 3 -> {
                            String newBloodGroup = input.readBloodGroup(sc, "Enter new Blood Group: ");
                            s.setBloodGroup(newBloodGroup);
                            System.out.println("Blood Group updated successfully!");
                        }
                        case 4 -> {
                            String newCourse = input.readNonEmptyString(sc, "Enter new Course: ");
                            s.setCourse(newCourse);
                            System.out.println("Course updated successfully!");
                        }
                        case 5 -> {
                            String newFatherName = input.readNonEmptyString(sc, "Enter new Father's Name: ");
                            s.setFatherName(newFatherName);
                            System.out.println("Father's Name updated successfully!");
                        }
                        case 6 -> {
                            String newContactNo = input.readContactNumber(sc, "Enter new Contact Number: ");
                            s.setContactNo(newContactNo);
                            System.out.println("Contact Number updated successfully!");
                        }
                        case 7 -> {
                            String newParentContactNo = input.readContactNumber(sc,
                                    "Enter new Parent's Contact Number: ");
                            s.setParentContactNo(newParentContactNo);
                            System.out.println("Parent's Contact Number updated successfully!");
                        }
                        case 8 -> {
                            String newAddress = input.readNonEmptyString(sc, "Enter new Address: ");
                            s.setAddress(newAddress);
                            System.out.println("Address updated successfully!");
                        }
                        case 9 -> {
                            double newPercent = input.readPercentage(sc, "Enter new Percentage: ");
                            s.setPercent(newPercent);
                            System.out.println("Percentage updated successfully!");
                        }
                        case 0 -> System.out.println("Exiting update menu...");
                        default -> System.out.println("Wrong input choice! Try again.");
                    }
                } while (change != 0);

                break; // student found, exit loop
            }
        }

        if (!found) {
            System.out.println("Student with ID " + searchID + " not found!");
        }
    }

    public void deleteStudent(Scanner sc, Input input) {
        int deleteID = input.readPositiveInt(sc, "Enter the ID of the student you want to delete: ");
        boolean found = false;

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getId() == deleteID) {
                found = true;
                System.out.println("\nStudent found!");
                s.displayStudentInfo();

                String choice = input.readNonEmptyString(sc,
                        "Are you sure you want to delete this student? (yes/no): ");
                if (choice.equalsIgnoreCase("yes")) {
                    it.remove();
                    System.out.println("Student details removed successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                break; // student found and handled
            }
        }

        if (!found) {
            System.out.println("Student with ID " + deleteID + " not found!");
        }
    }

    public void searchStudent(Scanner sc, Input input) {
        int searchID = input.readPositiveInt(sc, "Enter the ID of the student you want to search: ");
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == searchID) {
                found = true;
                System.out.println("\nStudent found!");
                System.out.println("Details of the student:");
                s.displayStudentInfo();
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + searchID + " not found!");
        }
    }

    // find top scorer
    public void topScorer() {
        if (students.isEmpty()) {
            System.out.println("No students available to evaluate top scorer.");
            return;
        }

        double maxPercent = -1.0;
        for (Student s : students) {
            if (s.getPercent() > maxPercent) {
                maxPercent = s.getPercent();
            }
        }

        System.out.println("\nTop Scorer(s) with " + maxPercent + "%:");
        int count = 1;
        for (Student s : students) {
            if (s.getPercent() == maxPercent) {
                System.out.println("\n--- Student " + count + " ---");
                s.displayStudentInfo();
                count++;
            }
        }
    }

    // display students by course
    public void displayStudentByCourse(Scanner sc, Input input) {
        String searchCourse = input.readNonEmptyString(sc, "Enter the course name you want to see: ").trim();
        boolean found = false;
        int count = 0;

        System.out.println("\nStudents enrolled in " + searchCourse + ":");

        for (Student s : students) {
            if (s.getCourse().equalsIgnoreCase(searchCourse)) {
                found = true;
                count++;
                System.out.println("\n--- Student " + count + " ---");
                s.displayStudentInfo();
            }
        }

        if (found) {
            System.out.println("\nNumber of students in " + searchCourse + ": " + count);
        } else {
            System.out.println("No students enrolled in " + searchCourse);
        }
    }

    // sort students via percentage
    public void sort() {
        if (students.isEmpty()) {
            System.out.println("No students available to sort.");
            return;
        }

        // Sort students in descending order of percentage
        students.sort((s1, s2) -> Double.compare(s2.getPercent(), s1.getPercent()));

        System.out.println("\nStudents sorted by percentage (highest to lowest):");
        int count = 1;
        for (Student s : students) {
            System.out.println("\n--- Student " + count + " ---");
            s.displayStudentInfo();
            count++;
        }
    }

}
