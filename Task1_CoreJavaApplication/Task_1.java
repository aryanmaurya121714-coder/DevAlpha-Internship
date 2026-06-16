
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private  String name;
    private String course;
    private double marks;

    public Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void displayStudent() {
        System.out.println("--------------------------------");
        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Course       : " + course);
        System.out.println("Marks        : " + marks);
        System.out.println("Grade        : " + calculateGrade());
    }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "Fail";
    }
}
public class Task_1 {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, course, marks));
        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student record found.");
            return;
        }

        for (Student s : students) {
            s.displayStudent();
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                s.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you for using Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }
    
}

