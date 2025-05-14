<%@ page import="java.sql.*" %>
<html>
<head><title>Employee Management</title></head>
<body>
    <h3>Insert Employee</h3>
    <form method="post">
        ID: <input type="text" name="id"><br>
        Name: <input type="text" name="name"><br>
        Post: <input type="text" name="post"><br>
        Salary: <input type="text" name="salary"><br>
        <input type="submit" name="insert" value="Insert">
    </form>
    <h3>Employee List</h3>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Post</th><th>Salary</th></tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Updated for MySQL 8
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
                
                if (request.getParameter("insert") != null) {
                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO employees (id, name, post, salary) VALUES (?, ?, ?, ?)"
                    );
                    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                    ps.setString(2, request.getParameter("name"));
                    ps.setString(3, request.getParameter("post"));
                    ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));
                    ps.executeUpdate();
                }

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM employees");
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getInt("id") + "</td><td>"
                        + rs.getString("name") + "</td><td>"
                        + rs.getString("post") + "</td><td>"
                        + rs.getDouble("salary") + "</td></tr>");
                }
                con.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
    </table>
</body>
</html>
