import java.sql.*;
import java.util.Scanner;

public class Prepared {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/studentdb";
        String username = "root";
        String password = ""; 

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Scanner scanner = new Scanner(System.in)) {
            
            try (Statement statement = connection.createStatement()) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS student (" +
                                      "roll_no INT PRIMARY KEY, " +
                                      "name VARCHAR(50), " +
                                      "level VARCHAR(20), " +
                                      "division VARCHAR(10), " +
                                      "major VARCHAR(50))";
                statement.executeUpdate(createTableSQL);
                System.out.println("Student table created/verified.");
            }
            
            String insertSQL = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("\nEnter details for student " + i + ":");
                    
                    System.out.print("Roll No: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Level: ");
                    String level = scanner.nextLine();
                    
                    System.out.print("Division: ");
                    String division = scanner.nextLine();
                    
                    System.out.print("Major: ");
                    String major = scanner.nextLine();
                    
                    statement.setInt(1, rollNo);
                    statement.setString(2, name);
                    statement.setString(3, level);
                    statement.setString(4, division);
                    statement.setString(5, major);
                    
                    statement.executeUpdate();
                    System.out.println("Student record added successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}