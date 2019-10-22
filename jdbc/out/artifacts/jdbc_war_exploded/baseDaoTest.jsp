<%@ page import="cn.lv.dao.BaseDao" %>
<%@ page import="cn.lv.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-10-22
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        BaseDao baseDao = new BaseDao();

        //iud
//        String sql = "INSERT INTO `users` SET `username`=?, `password`=?, `phone_no`=?, `address`=?, `reg_date`=?;";
//        baseDao.iud(sql,"wutingting","123456","9090909900","美国","2018-4-8");
//        String sql = "update `users` set `username`=? where id=?";
//        baseDao.iud(sql, "tingtingwu",16);
//        String sql = "delete from `users` where id=?";
//        baseDao.iud(sql, 16);

//        String sql = "select id id,`username` userName,`password` password,`phone_no` phoneNo,`address` address,`reg_date` regDate from users where id=?";
//        User user = baseDao.getOneData(User.class, sql, 15);
//        out.print(user.getUserName());

//        String sql = "select id id,`username` userName,`password` password,`phone_no` phoneNo,`address` address,`reg_date` regDate from users";
//        List<User> list = baseDao.getListData(User.class, sql);
//        out.println(Arrays.toString(list.toArray()));

        String sql = "select count(*) from users";
        Long count = (Long)baseDao.getOneColumn(sql);
        out.println(count);

    %>
</body>
</html>
