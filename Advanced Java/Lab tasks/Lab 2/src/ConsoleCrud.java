import java.sql.*;
import java.util.Scanner;

public class ConsoleCrud {
    private static final String URL = "jdbc:mysql://localhost:3307/BookDb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; 

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            
            while (true) {
                System.out.println("\nBook Management System");
                System.out.println("1. Add Book");
                System.out.println("2. View All Books");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        addBook(connection, scanner);
                        break;
                    case 2:
                        viewAllBooks(connection);
                        break;
                    case 3:
                        updateBook(connection, scanner);
                        break;
                    case 4:
                        deleteBook(connection, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addBook(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter publication: ");
        String publication = scanner.nextLine();
        
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        
        String sql = "INSERT INTO Book_info VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.setString(4, publication);
            statement.setInt(5, price);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Book added successfully!");
            }
        }
    }

    private static void viewAllBooks(Connection connection) throws SQLException {
        String sql = "SELECT * FROM Book_info";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            System.out.println("\nID\tTitle\t\tAuthor\t\tPublication\tPrice");
            System.out.println("--------------------------------------------------");
            while (resultSet.next()) {
                System.out.println(
                    resultSet.getInt("id") + "\t" +
                    resultSet.getString("title") + "\t" +
                    resultSet.getString("author") + "\t" +
                    resultSet.getString("publication") + "\t" +
                    resultSet.getInt("price")
                );
            }
        }
    }

    private static void updateBook(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter new publication: ");
        String publication = scanner.nextLine();
        
        System.out.print("Enter new price: ");
        int price = scanner.nextInt();
        
        String sql = "UPDATE Book_info SET title=?, author=?, publication=?, price=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, publication);
            statement.setInt(4, price);
            statement.setInt(5, id);
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("No book found with ID: " + id);
            }
        }
    }

    private static void deleteBook(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        
        String sql = "DELETE FROM Book_info WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("No book found with ID: " + id);
            }
        }
    }
}