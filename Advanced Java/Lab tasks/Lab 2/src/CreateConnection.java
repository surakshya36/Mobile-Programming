import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/";
        String username = "root";
        String password = ""; 

        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(url, username, password);
            
            if (connection != null) {
                System.out.println("Successfully connected to the database server!");
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}