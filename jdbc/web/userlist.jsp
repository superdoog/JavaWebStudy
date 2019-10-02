<%@ page import="com.mysql.jdbc.Connection" %>
<%@ page import="cn.lv.jdbc.DBUtils" %><%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-09-28
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
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



  </body>
</html>
