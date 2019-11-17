<%@ page import="cn.lv.mvcproject.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-11-17
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<head>
    <title>Title</title>
    <style>
        tr{height: 35px;}
        td{padding: 10px;}
    </style>
</head>
<body>
<%User user = (User)request.getAttribute("user");%>
<form action="<%=request.getContextPath()%>/updatedo.udo" method="post">
    <table style="margin-left: 100px;padding: 50px;border: 1px #cccccc solid;width: 400px;">
        <input type="hidden" name="id" value="<%=user.getId()%>">
        <%
            String note = (String) request.getAttribute("note");
            if (note!=null&&!"".equals(note))
            {
        %>
        <tr>
            <td style="text-align: right; color: red; font-weight: bold"><%=note%></td>
        </tr>
        <%}%>
        <tr>
            <td style="text-align: right">用户名：</td>
            <td style="text-align: left"><input type="text" name="username" value="<%=user.getUsername()%>"></td>
        </tr>
        <tr>
            <td style="text-align: right">用户密码：</td>
            <td style="text-align: left"><input type="text" name="pasword" value="<%=user.getPasword()%>"></td>
        </tr>
        <tr>
            <td style="text-align: right">用户地址：</td>
            <td style="text-align: left"><input type="text" name="address" value="<%=user.getAddress()%>"></td>
        </tr>
        <tr>
            <td style="text-align: right">用户电话：</td>
            <td style="text-align: left"><input type="text" name="phoneNo" value="<%=user.getPhoneNo()%>"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="修改新用户">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
