<%@ page import="java.sql.Connection" %>
<%@ page import="cn.lv.jdbc.MyDBUtils" %>
<%@ page import="java.sql.Statement" %><%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-10-10
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%

        String sql = "delete from users where id=9;";

       int count = MyDBUtils.IUD(sql);

        if (count > 0){
            out.println("删除成功");
        }

    %>
</body>
</html>
