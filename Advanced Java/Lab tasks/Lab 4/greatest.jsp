<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <form method="post">
        Number 1: <input type="text" name="num1"><br>
        Number 2: <input type="text" name="num2"><br>
        Number 3: <input type="text" name="num3"><br>
        <input type="submit" value="Find Greatest">
    </form>
    <% 
        if (request.getMethod().equals("POST")) {
            int a = Integer.parseInt(request.getParameter("num1"));
            int b = Integer.parseInt(request.getParameter("num2"));
            int c = Integer.parseInt(request.getParameter("num3"));
            int max = Math.max(a, Math.max(b, c));
            out.println("Greatest: " + max);
        }
    %>
</body>
</html>