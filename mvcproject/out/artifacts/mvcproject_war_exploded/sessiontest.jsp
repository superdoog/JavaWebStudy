<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    HttpSession session2 = request.getSession();

    session2.setAttribute("users", "admin");

    out.println("取出session2里的users这个key的value:" + session2.getAttribute("users"));


%>

<a href="<%=response.encodeURL("/testServlet.udo")%>"></a>

</body>
</html>
