
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // Update these details with your local MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/smart_camp";
    private static final String USER = "root"; // Default MySQL user
    private static final String PASSWORD = "M@ni2288"; // Your MySQL root password

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Explicitly load the modern MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}

