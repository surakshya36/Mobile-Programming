import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(req.getParameter("id")));
            ps.setString(2, req.getParameter("name"));
            ps.setString(3, req.getParameter("post"));
            ps.setDouble(4, Double.parseDouble(req.getParameter("salary")));
            ps.executeUpdate();
            res.getWriter().println("Record saved!");
            con.close();
        } catch (Exception e) {
            res.getWriter().println("Error: " + e.getMessage());
        }
    }
}