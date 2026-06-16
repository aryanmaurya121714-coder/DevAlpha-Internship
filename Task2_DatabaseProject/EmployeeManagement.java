import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {

    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            String query = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);

            ps.executeUpdate();
            System.out.println("Employee added successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void viewEmployees() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\nID\tName\tDepartment\tSalary");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("department") + "\t\t" +
                    rs.getDouble("salary")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void searchEmployee() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID to search: ");
            int id = sc.nextInt();

            String query = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            } else {
                System.out.println("Employee not found.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void deleteEmployee() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM employee WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}