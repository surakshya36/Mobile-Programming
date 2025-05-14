<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <h3>Cookie Value: 
        <% 
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    out.println(c.getValue());
                }
            }
        %>
    </h3>
    <h3>Session Login Time: <%= session.getAttribute("loginTime") %></h3>
</body>
</html>