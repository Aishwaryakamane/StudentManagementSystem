import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementRecorde {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1: Add Student");
            System.out.println("2: View Student");
            System.out.println("3: Update Student");
            System.out.println("4: Delete Student");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 :
                    addStudent();
                    break;
                case 2 : viewStudent();
                    break;
                case 3 : updateStudent();
                    break;
                case 4 : deleteStudent();
                    break;
                case 5 : System.out.println("Exiting...");
                   break;
                default : System.out.println("Invalid Choice. Try again");
            }

        } while (choice != 5);
    }

    private static void addStudent() {
        int id;
        while (true) {
            System.out.print("Enter Student ID : ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                if (id > 0 && getStudentById(id) == null) break;
                else System.out.println("ID must be positive and unique.");
            } else {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
            }
        }

        String name;
        while (true) {
            System.out.print("Enter new Name : ");
            name = sc.nextLine();
            if (name.matches("[a-zA-Z ]+")) break;
            else System.out.println("Invalid name. Use letters only.");
        }

        double marks;
        while (true) {
            System.out.print("Enter new Marks : ");
            if (sc.hasNextDouble()) {
                marks = sc.nextDouble();
                if (marks >= 0 && marks <= 100) break;
                else System.out.println("Marks must be between 0 and 100.");
            } else {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
            }
        }

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudent() {
        if (students.isEmpty()) {
            System.out.println("No Student record found");
        } else {
            System.out.println("\n_______Student List__________");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = getStudentById(id);
        if (s == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid name. Update aborted.");
            return;
        }

        System.out.print("Enter new marks: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid marks. Update aborted.");
            sc.next();
            return;
        }
        double marks = sc.nextDouble();
        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100. Update aborted.");
            return;
        }

        s.setName(name);
        s.setMark(marks);
        System.out.println("Student Updated Successfully!");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        Student s = getStudentById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted Successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    private static Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
