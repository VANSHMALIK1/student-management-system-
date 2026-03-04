import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db",
                    "root",
                    "your_password"   // yaha apna MySQL password dalna
            );
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
