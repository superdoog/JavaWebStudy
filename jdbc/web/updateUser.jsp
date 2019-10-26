
<%@ page import="cn.lv.jdbc.MyDBUtils" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-10-10
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //获取表单提交过来的数据
    request.setCharacterEncoding("UTF-8");//解决中文乱码问题
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String phoneNo = request.getParameter("phoneNo");
    String address = request.getParameter("address");

    String sql = "UPDATE users set username = '"+username+"',`password` = '"+password+"'," +
            "phone_no = '"+phoneNo+"',address = '"+address+"' WHERE id = 8";

    int count = MyDBUtils.IUD(sql);

    if (count > 0){
        out.println("修改成功");
    }
%>

</body>
</html>
