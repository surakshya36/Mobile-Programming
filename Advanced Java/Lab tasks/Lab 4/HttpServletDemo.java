import javax.servlet.http.*;
import java.io.IOException;

public class HttpServletDemo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().println("Hello from HttpServletDemo!");
    }
}