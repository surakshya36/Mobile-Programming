import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class InterestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        double p = Double.parseDouble(req.getParameter("principal"));
        double r = Double.parseDouble(req.getParameter("rate"));
        double t = Double.parseDouble(req.getParameter("time"));
        double si = (p * r * t) / 100;
        req.setAttribute("result", si);
        req.getRequestDispatcher("result.jsp").forward(req, res);
    }
}