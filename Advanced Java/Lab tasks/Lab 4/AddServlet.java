import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int sum = num1 + num2;
        res.getWriter().println("Sum: " + sum);
    }
}