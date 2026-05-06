import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Add Student
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    students.add(new Student(id, name, age, course));

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    // View Students
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == searchId) {
                            s.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    Student studentToDelete = null;

                    for (Student s : students) {
                        if (s.id == deleteId) {
                            studentToDelete = s;
                        }
                    }

                    if (studentToDelete != null) {
                        students.remove(studentToDelete);
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 5:
                    // Update Student
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Student s : students) {

                        if (s.id == updateId) {

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Age: ");
                            s.age = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Course: ");
                            s.course = sc.nextLine();

                            updated = true;

                            System.out.println("Student Updated Successfully!");
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}