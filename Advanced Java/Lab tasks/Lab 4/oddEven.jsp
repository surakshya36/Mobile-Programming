<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <form method="post">
        Enter a number: <input type="text" name="num"><br>
        <input type="submit" value="Check">
    </form>
    <% 
        if (request.getMethod().equals("POST")) {
            int num = Integer.parseInt(request.getParameter("num"));
            if (num % 2 == 0) out.println(num + " is Even.");
            else out.println(num + " is Odd.");
        }
    %>
</body>
</html>