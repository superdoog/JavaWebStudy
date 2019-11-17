<%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-09-26
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%= pageContext.getAttribute("pageContext")%><br>
    <%= request.getAttribute("request")%><br>
    <%= session.getAttribute("session")%><br>
    <%= application.getAttribute("application")%><br>

</body>
</html>
