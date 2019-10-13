<%@ page import="java.sql.Connection" %>
<%@ page import="cn.lv.jdbc.DBUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.Date" %>
<%@ page import="cn.lv.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        User u = new User();

        //获取表单提交过来的数据
        request.setCharacterEncoding("UTF-8");//解决中文乱码问题
        u.setUserName(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        u.setPhoneNo(request.getParameter("phoneNo"));
        u.setAddress(request.getParameter("address"));
        u.setRegDate(new Date());


//        String sql = "INSERT INTO users(username,password,phone_no,address,reg_date)"+
//                "VALUES('"+u.getUserName()+"', '"+u.getPassword()+"','"+u.getPhoneNo()+"','"+u.getAddress()+"','"+
//                new java.sql.Date(u.getRegDate().getTime())+"');";

        String sql = "INSERT INTO users(`username`,`password`,`phone_no`,`address`,`reg_date`)values(?,?,?,?,?)";

        int count = DBUtils.IUD(sql,u.getUserName(),u.getPassword(),
                u.getPhoneNo(),u.getAddress(),new java.sql.Date(u.getRegDate().getTime()));

        if (count > 0){
            out.println("插入成功");
        }
    %>

</body>
</html>
