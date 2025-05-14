import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDb {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/";
        String username = "root";
        String password = ""; 
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BookDb");
            System.out.println("Database BookDb created successfully!");
            
            statement.executeUpdate("USE BookDb");
           
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Book_info (" +
                                   "id INT PRIMARY KEY, " +
                                   "title VARCHAR(20), " +
                                   "author VARCHAR(20), " +
                                   "publication VARCHAR(20), " +
                                   "price INT)";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table Book_info created successfully!");
            
        } catch (SQLException e) {
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
    }
}