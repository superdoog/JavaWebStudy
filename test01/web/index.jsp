<%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-09-24
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>Page Title</title>
</head>
<body>
  <form action="/test01_war_exploded/servlet1" method="get">
    <br/>
    请输入用户名：<input type="text" name="username">
    <br/>
    请输入 密 码 ：<input type="password" name="password">
    <br/>
    爱好：<input type="checkbox" name="aihao" value="lq">篮球
          <input type="checkbox" name="aihao" value="tw">跳舞
    <input type="submit">
  </form>
</body>
</html>

