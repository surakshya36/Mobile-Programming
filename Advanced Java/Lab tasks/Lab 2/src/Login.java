import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    public Login() {
        createLoginFrame();
    }
    private void createLoginFrame() {
        loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridLayout(3, 2, 10, 10));
        loginFrame.setLocationRelativeTo(null);

        loginFrame.add(new JLabel("Username:"));
        usernameField = new JTextField();
        loginFrame.add(usernameField);

        loginFrame.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        loginFrame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> authenticateUser());
        loginFrame.add(loginButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> System.exit(0));
        loginFrame.add(cancelButton);

        loginFrame.setVisible(true);
    }
    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/BookDb", 
                "root", 
                "")) { 
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                        loginFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(loginFrame, 
                            "Invalid username or password!", 
                            "Login Failed", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(loginFrame, 
                "Database error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        createUsersTable();
        SwingUtilities.invokeLater(Login::new);
    }
    private static void createUsersTable() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/BookDb", 
                "root", 
                "")) { 
            
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(20) UNIQUE, " +
                    "password VARCHAR(20))");
                
                statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Book_info (" +
                    "id INT PRIMARY KEY, " +
                    "title VARCHAR(20), " +
                    "author VARCHAR(20), " +
                    "publication VARCHAR(20), " +
                    "price INT)");
                
                ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM users");
                rs.next();
                if (rs.getInt(1) == 0) {
                    statement.executeUpdate(
                        "INSERT INTO users (username, password) VALUES ('admin', 'admin123')");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Error creating tables: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}