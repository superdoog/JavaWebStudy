<%@ page import="cn.lv.jdbc.DBUtils" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <%
      Connection conn = DBUtils.getConnection();

    %>

  <%=conn%>

  <form action="insertUser.jsp" method="get" style="margin: 0 auto; width: 500px;padding: 20px; border: 1px #cccccc solid;text-align: center;">
    用户名:<input type="text" name="username">
    <br>
    <br>
    密 码:<input type="text" name="password">
    <br>
    <br>
    电话号:<input type="text" name="phoneNo">
    <br>
    <br>
    住 址:<input type="text" name="address">
    <br>
    <br>
    <input type="submit">
  </form>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <form action="getOneUser.jsp" method="post" style="margin: 0 auto; width: 500px;padding: 20px; border: 1px #cccccc solid;text-align: center;">
      用户编号:<input type="text" name="userid">
      <br>
      <br>
      <input type="submit">
    </form>


  </body>
</html>
