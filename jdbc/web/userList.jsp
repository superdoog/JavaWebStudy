<%@ page import="cn.lv.jdbc.MyDBUtils" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %><%--
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
    查询用户信息的页面：
    <br>
    <%
      String userid = request.getParameter("userid");
      Connection conn = null;
      Statement statement = null;
      ResultSet rs = null;

      try {
        //获取数据库连接
        conn = MyDBUtils.getConnection();
        String sql = "select id,username,`password`,phone_no,address,reg_date from users";
        //获取statement对象
        statement = conn.createStatement();
        //执行sql语句
        rs = statement.executeQuery(sql);
        //获取rs结果集中拿具体结果集中的数值
        while (rs.next()){
          int id = rs.getInt("id");
          String username = rs.getString("username");
          String password = rs.getString("password");
          String phoneNo = rs.getString("phone_no");
          String address = rs.getString("address");
          String regDate  = rs.getDate("reg_date").toString();

          out.println(id+"---"+username+"---"+password+"---"+phoneNo+"---"+address+"---"+regDate);
          out.println("<br><br>");
        }
      }catch (Exception e){
        e.printStackTrace();
      }finally {
        MyDBUtils.close(conn,statement,rs);
      }
    %>




  </body>
</html>
