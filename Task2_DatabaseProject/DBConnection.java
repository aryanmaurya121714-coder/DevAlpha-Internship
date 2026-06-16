import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        //user-root
        //password-Aryan@12345

        try {
            String url = "jdbc:mysql://localhost:3306/employee_db";
            String user = "root";
            String password = "root"; // yaha apna MySQL password likho

            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e);
        }

        return con;
    }
}