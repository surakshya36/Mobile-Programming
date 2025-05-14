import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Crud extends JFrame {
    private JTextField rollNoField, nameField, levelField, divisionField, majorField;
    private JButton saveButton, deleteButton, editButton, displayButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private Connection connection;

    public Crud() {
        // Initialize database connection
        initializeDatabase();
        
        // Set up the main frame
        setupFrame();
        
        // Create and add components
        add(createFormPanel(), BorderLayout.NORTH);
        add(createButtonPanel(), BorderLayout.CENTER);
        add(createTableScrollPane(), BorderLayout.SOUTH);
        
        // Add action listeners
        addActionListeners();
        
        setVisible(true);
    }

    private void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/studentdb", 
                "root", 
                ""
            );
            // Create table if not exists
            createStudentTable();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            System.exit(1);
        }
    }

    private void createStudentTable() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS student (" +
                "roll_no INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "level VARCHAR(20), " +
                "division VARCHAR(10), " +
                "major VARCHAR(50))"
            );
        }
    }

    private void setupFrame() {
        setTitle("Student Management System");
        setSize(800, 600); // Increased height for better visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        panel.setBackground(new Color(240, 240, 240));

        addFormField(panel, "Roll No:", rollNoField = new JTextField());
        addFormField(panel, "Name:", nameField = new JTextField());
        addFormField(panel, "Level:", levelField = new JTextField());
        addFormField(panel, "Division:", divisionField = new JTextField());
        addFormField(panel, "Major:", majorField = new JTextField());

        return panel;
    }

    private void addFormField(JPanel panel, String label, JTextField field) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(jLabel);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(field);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(240, 240, 240));

        saveButton = createStyledButton("Save", Color.GREEN.darker());
        deleteButton = createStyledButton("Delete", Color.RED.darker());
        editButton = createStyledButton("Edit", Color.BLUE.darker());
        displayButton = createStyledButton("Display", Color.ORANGE.darker());

        panel.add(saveButton);
        panel.add(deleteButton);
        panel.add(editButton);
        panel.add(displayButton);

        return panel;
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 40));
        return button;
    }

    private JScrollPane createTableScrollPane() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Roll No");
        tableModel.addColumn("Name");
        tableModel.addColumn("Level");
        tableModel.addColumn("Division");
        tableModel.addColumn("Major");

        studentTable = new JTable(tableModel);
        studentTable.setFont(new Font("Arial", Font.PLAIN, 14));
        studentTable.setRowHeight(25);
        studentTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Student Records"));
        scrollPane.setPreferredSize(new Dimension(750, 200));

        return scrollPane;
    }
    private void addActionListeners() {
        saveButton.addActionListener(e -> saveStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        editButton.addActionListener(e -> editStudent());
        displayButton.addActionListener(e -> displayStudents());
        studentTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow >= 0) {
                    rollNoField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    levelField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    divisionField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    majorField.setText(tableModel.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }
    private void saveStudent() {
        try {
            int rollNo = Integer.parseInt(rollNoField.getText());
            String name = nameField.getText();
            String level = levelField.getText();
            String division = divisionField.getText();
            String major = majorField.getText();

            boolean exists = false;
            String checkSql = "SELECT * FROM student WHERE roll_no=?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
                checkStmt.setInt(1, rollNo);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    exists = rs.next();
                }
            }

            String sql;
            if (exists) {
                sql = "UPDATE student SET name=?, level=?, division=?, major=? WHERE roll_no=?";
            } else {
                sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                if (exists) {
                    statement.setString(1, name);
                    statement.setString(2, level);
                    statement.setString(3, division);
                    statement.setString(4, major);
                    statement.setInt(5, rollNo);
                } else {
                    statement.setInt(1, rollNo);
                    statement.setString(2, name);
                    statement.setString(3, level);
                    statement.setString(4, division);
                    statement.setString(5, major);
                }
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, 
                        exists ? "Student updated successfully!" : "Student added successfully!");
                    clearFields();
                    displayStudents();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Roll Number!", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void deleteStudent() {
        try {
            int rollNo = Integer.parseInt(rollNoField.getText());

            String sql = "DELETE FROM student WHERE roll_no=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, rollNo);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                    clearFields();
                    displayStudents();
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with Roll No: " + rollNo, 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Roll Number!", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void editStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow >= 0) {
            rollNoField.setText(tableModel.getValueAt(selectedRow, 0).toString());
            nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
            levelField.setText(tableModel.getValueAt(selectedRow, 2).toString());
            divisionField.setText(tableModel.getValueAt(selectedRow, 3).toString());
            majorField.setText(tableModel.getValueAt(selectedRow, 4).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit!", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void displayStudents() {
        try {
            String sql = "SELECT * FROM student";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                
                tableModel.setRowCount(0);
                
                while (resultSet.next()) {
                    tableModel.addRow(new Object[]{
                        resultSet.getInt("roll_no"),
                        resultSet.getString("name"),
                        resultSet.getString("level"),
                        resultSet.getString("division"),
                        resultSet.getString("major")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error retrieving students: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void clearFields() {
        rollNoField.setText("");
        nameField.setText("");
        levelField.setText("");
        divisionField.setText("");
        majorField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Crud crud = new Crud();
            crud.setLocationRelativeTo(null); // Center the window
        });
    }
}