<%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-09-24
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>Page Title</title>
</head>
<body>
<%--  <form action="/test01_war_exploded/servlet1" method="get">--%>
<%--    <br/>--%>
<%--    请输入用户名：<input type="text" name="username">--%>
<%--    <br/>--%>
<%--    请输入 密 码 ：<input type="password" name="password">--%>
<%--    <br/>--%>
<%--    爱好：<input type="checkbox" name="aihao" value="lq">篮球--%>
<%--          <input type="checkbox" name="aihao" value="tw">跳舞--%>
<%--    <input type="submit">--%>
<%--  </form>--%>

  <%
    //pageContext
    pageContext.setAttribute("pageContext", "pageContextRest");

    //request
    request.setAttribute("request", "requestTest");

    //session
    session.setAttribute("session", "sessionTest");

    //application
    application.setAttribute("application", "applicationTest");

  %>

  <a href="index2.jsp">跳转到index2.jsp</a>
  <br>
  <a href="/test01_war_exploded/loginServlet">跳转到loginServlet</a>
  <br>
  <%= pageContext.getAttribute("pageContext")%><br>
  <%= request.getAttribute("request")%><br>
  <%= session.getAttribute("session")%><br>
  <%= application.getAttribute("application")%><br>
</body>
</html>

