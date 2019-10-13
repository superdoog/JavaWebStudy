<%@ page import="java.sql.Connection" %>
<%@ page import="cn.lv.jdbc.DBUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="cn.lv.model.User" %><%--
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
        String userid = request.getParameter("userid");

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        User user = null;

        try {
        	//连接数据库
            conn = DBUtils.getConnection();
            //写sql语句
            String sql = "select id,username,`password`,phone_no,address,reg_date from users where id="+userid;
            //执行sql,获取statement对象
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            //从rs中拿出数据库取出的具体值
            if (rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setUserName(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setPassword(rs.getString("phone_no"));
            	user.setAddress(rs.getString("address"));
            	user.setRegDate(rs.getDate("reg_date"));
            }
            if (user != null){
            	out.println(user);
            }else {
            	out.println("无此用户");
            }
        }catch (Exception e){
        	e.printStackTrace();
        }finally {

        }
    %>

</body>
</html>
