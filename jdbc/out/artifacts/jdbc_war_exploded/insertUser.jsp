<%@ page import="java.sql.Connection" %>
<%@ page import="cn.lv.jdbc.DBUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.Date" %>
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

        String sql = "INSERT INTO users(username,password,phone_no,address,reg_date)"+
                "VALUES('"+username+"', '"+password+"','"+phoneNo+"','"+address+"','"+
                new java.sql.Date(new java.util.Date().getTime())+"');";

        int count = DBUtils.IUD(sql);

        if (count > 0){
            out.println("插入成功");
        }
    %>

</body>
</html>
