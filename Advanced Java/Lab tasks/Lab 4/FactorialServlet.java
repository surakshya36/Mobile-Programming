import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FactorialServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int n = Integer.parseInt(req.getParameter("num"));
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        res.getWriter().println("Factorial: " + fact);
    }
}