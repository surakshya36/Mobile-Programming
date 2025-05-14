import java.sql.*;

public class Distinction {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/studentdb";
        String username = "root";
        String password = ""; 

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM student WHERE division='Distinction' AND major='Data Science'";
            
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                
                System.out.println("\nStudents with Distinction in Data Science:");
                System.out.println("Roll No\tName\t\tLevel\t\tDivision\tMajor");
                System.out.println("--------------------------------------------------");
                
                while (resultSet.next()) {
                    System.out.println(
                        resultSet.getInt("roll_no") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("level") + "\t" +
                        resultSet.getString("division") + "\t\t" +
                        resultSet.getString("major")
                    );
                }
                
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No students found with Distinction in Data Science.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}