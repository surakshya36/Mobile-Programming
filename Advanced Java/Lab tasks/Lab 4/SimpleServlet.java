import javax.servlet.*;
import java.io.IOException;

public class SimpleServlet implements Servlet {
    public void init(ServletConfig config) throws ServletException {}
    public ServletConfig getServletConfig() { return null; }
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        res.getWriter().println("Hello from SimpleServlet!");
    }
    public String getServletInfo() { return null; }
    public void destroy() {}
}