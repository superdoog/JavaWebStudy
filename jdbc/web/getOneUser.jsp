<%@ page import="java.sql.Connection" %>
<%@ page import="cn.lv.jdbc.DBUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="cn.lv.model.User" %>
<%@ page import="cn.lv.dao.BaseDao" %><%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-10-13
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
//        String userid = request.getParameter("userid");
//            //写sql语句
//            String sql = "select id id,username userName,password password from users where id=?";
//            //调用方法
//            //User user = DBUtils.getOneUser(sql, userid);
//            User user = DBUtils.getOneData(User.class, sql, userid);
//            if (user != null){
//            	out.println(user);
//            }else {
//            	out.println("无此用户");
//            }
        BaseDao baseDao = new BaseDao();
        String sql = "select id id,username userName from users where id=2";
        User u = baseDao.getOneData(User.class, sql);

        out.println(u);

    %>

</body>
</html>
