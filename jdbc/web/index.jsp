<%@ page import="com.mysql.jdbc.Connection" %>
<%@ page import="cn.lv.jdbc.DBUtils" %>
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
