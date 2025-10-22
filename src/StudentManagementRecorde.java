import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StudentManagementRecorde {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Student Record Management System");
            System.out.println("1: Add Student");
            System.out.println("2: View Student");
            System.out.println("3: Update Student");
            System.out.println("4: Delete Student");
            System.out.println("5: Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Invalid Choice. Try again");
            }

        }while (choice != 5);

    }
    private static void addStudent(){
        System.out.println("Enter Student ID ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students){
            if (s.getId() == id){
                System.out.println("Student ID already Exists!");
                return;
            }
        }
        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Marks: ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100){
            System.out.println("Marks must be between 0 and 100");
            return;
        }

        students.add(new Student(id,name,marks));
        System.out.println("Student added successfully! ");
    }
    private static void viewStudent(){
        if (students.isEmpty()){
            System.out.println("No Student record found");
        }else {
            System.out.println("\n_______Student List__________");
            for (Student s: students){
                System.out.println(s);
            }
        }
    }
    private static void updateStudent(){
        System.out.println("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s: students){
            if (s.getId() == id){
                System.out.println("Enter new name: ");
                String name = sc.nextLine();
                System.out.println("Enter new marks: ");
                double marks = sc.nextDouble();

                if(marks < 0 || marks > 100){
                    System.out.println("Marks must be between 0 and 100! ");
                    return;
                }
                s.setName(name);
                s.setMark(marks);
                System.out.println("Student Updated Successfully! ");
                return;
            }

        }
        System.out.println("Student not found ");
    }
    private static void deleteStudent(){
        System.out.println("Enter student id to delete: ");
        int id = sc.nextInt();

        for (Student s : students){
            if (s.getId() == id){
                students.remove(s);
                System.out.println("Student delete Successfully! ");
                return;
            }
        }
        System.out.println("Student not found! ");
    }
}