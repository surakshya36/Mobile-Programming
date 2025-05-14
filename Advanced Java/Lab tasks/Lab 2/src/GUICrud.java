import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class GUICrud extends JFrame {
    private JTextField idField, titleField, authorField, publicationField, priceField;
    private JButton addButton, updateButton, deleteButton, viewButton, clearButton;
    private JTextArea resultArea;
    private Connection connection;

    public GUICrud() {
        // Initialize database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/BookDb", 
                "root", 
                "" 
            );
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            System.exit(1);
        }

        // Initialize UI components
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Book Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = createFormPanel();
        add(formPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.CENTER);

        // Result area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(650, 250));
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("Publication:"));
        publicationField = new JTextField();
        panel.add(publicationField);

        panel.add(new JLabel("Price:"));
        priceField = new JTextField();
        panel.add(priceField);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        viewButton = new JButton("View All");
        clearButton = new JButton("Clear");

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        viewButton.addActionListener(e -> viewAllBooks());
        clearButton.addActionListener(e -> clearFields());

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(viewButton);
        panel.add(clearButton);

        return panel;
    }

    // All CRUD operation methods remain the same as in your original code
    private void addBook() {
        try {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String author = authorField.getText();
            String publication = publicationField.getText();
            int price = Integer.parseInt(priceField.getText());

            String sql = "INSERT INTO Book_info VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.setString(2, title);
                statement.setString(3, author);
                statement.setString(4, publication);
                statement.setInt(5, price);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    resultArea.setText("Book added successfully!\n");
                    clearFields();
                }
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter valid numbers for ID and Price!\n");
        } catch (SQLException e) {
            resultArea.setText("Error adding book: " + e.getMessage() + "\n");
        }
    }

    private void updateBook() {
        try {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String author = authorField.getText();
            String publication = publicationField.getText();
            int price = Integer.parseInt(priceField.getText());

            String sql = "UPDATE Book_info SET title=?, author=?, publication=?, price=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.setString(2, author);
                statement.setString(3, publication);
                statement.setInt(4, price);
                statement.setInt(5, id);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    resultArea.setText("Book updated successfully!\n");
                } else {
                    resultArea.setText("No book found with ID: " + id + "\n");
                }
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter valid numbers for ID and Price!\n");
        } catch (SQLException e) {
            resultArea.setText("Error updating book: " + e.getMessage() + "\n");
        }
    }

    private void deleteBook() {
        try {
            int id = Integer.parseInt(idField.getText());

            String sql = "DELETE FROM Book_info WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    resultArea.setText("Book deleted successfully!\n");
                    clearFields();
                } else {
                    resultArea.setText("No book found with ID: " + id + "\n");
                }
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter a valid ID number!\n");
        } catch (SQLException e) {
            resultArea.setText("Error deleting book: " + e.getMessage() + "\n");
        }
    }

    private void viewAllBooks() {
        try {
            String sql = "SELECT * FROM Book_info";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                
                StringBuilder sb = new StringBuilder();
                sb.append("ID\tTitle\t\tAuthor\t\tPublication\tPrice\n");
                sb.append("--------------------------------------------------\n");
                
                while (resultSet.next()) {
                    sb.append(resultSet.getInt("id")).append("\t")
                      .append(resultSet.getString("title")).append("\t")
                      .append(resultSet.getString("author")).append("\t")
                      .append(resultSet.getString("publication")).append("\t")
                      .append(resultSet.getInt("price")).append("\n");
                }
                
                resultArea.setText(sb.toString());
            }
        } catch (SQLException e) {
            resultArea.setText("Error retrieving books: " + e.getMessage() + "\n");
        }
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        publicationField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUICrud::new);
    }
}