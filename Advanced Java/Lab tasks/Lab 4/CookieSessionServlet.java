import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CookieSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Cookie Example
        Cookie cookie = new Cookie("user", "John");
        cookie.setMaxAge(60 * 60); // 1 hour
        res.addCookie(cookie);

        // Session Example
        HttpSession session = req.getSession();
        session.setAttribute("loginTime", System.currentTimeMillis());

        res.getWriter().println("Cookie & Session set!");
    }
}