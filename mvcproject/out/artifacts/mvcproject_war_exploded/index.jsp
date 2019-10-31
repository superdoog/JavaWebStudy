
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      tr{height: 35px;}
      td{padding: 10px;}
    </style>
  </head>
  <body>
  <form action="<%=request.getContextPath()%>/query.udo" method="post">
    <table style="margin-left: 100px;padding: 50px;border: 1px #cccccc solid;width: 400px;">
     <tr>
        <td style="text-align: right">用户名：</td>
       <td style="text-align: left"><input type="text" name="username"></td>
      </tr>
     <tr>
        <td style="text-align: right">用户地址：</td>
        <td style="text-align: left"><input type="text" name="address"></td>
      </tr>
      <tr>
        <td style="text-align: right">用户电话：</td>
        <td style="text-align: left"><input type="text"   name="phoneNo"></td>
     </tr>

     <tr>
        <td colspan="2" style="text-align: center"><input type="submit" value="查询用户">
        <a href="<%=request.getContextPath()%>/add.udo"></a>
        </td>
     </tr>
    </table>

    <table style="margin-left: 100px;padding: 50px;" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td>用户ID</td><td>用户名称</td><td>用户密码</td><td>用户电话</td><td>用户地址</td><td>注册时间</td></tr>

        <td>用户ID</td><td>用户名称</td><td>用户密码</td><td>用户电话</td><td>用户地址</td><td>注册时间</td></tr>

      </table>
  </form>
  </body>
</html>
