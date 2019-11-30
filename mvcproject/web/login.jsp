<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript">
        function getCookie(c_name){
            var c_start, c_end;
            if (document.cookie.length > 0) {
                c_start = document.cookie.indexOf(c_name + "=");
                if (c_start != -1) {
                    c_start = c_start + c_name.length + 1;
                    c_end = document.cookie.indexOf(";", c_start);
                    if (c_end == -1) c_end = document.cookie.length;
                    return unescape(document.cookie.substring(c_start, c_end));
                }
            }
            return ""
        }

        window.onload = function () {
            var form = document.getElementById("loginform");
            var username = document.getElementById("username");
            if (getCookie("userKey") != "" && getCookie("userKey") != null && getCookie("ssid") != "" && getCookie("ssid") != null) {
                username.value = getCookie("userKey");
                form.submit();
            }
        }
    </script>
</head>
<body>
<br>
<br>
<% if (request.getAttribute("note") != null) {%>
<span style="color: red; font-weight: bolder;"><%=request.getAttribute("note")%></span>
<%}%>
<br>
<form id="loginform" action="<%=request.getContextPath()%>/login.udo">
    用户名:<input id="username" type="text" name="username" value="">
    <br>
    <br>
    密 码 :<input type="text" name="pasword">
    <br>
    <br>
    记住一周<input type="radio" name="expiredays" value="7"> 记住一个月<input type="radio" name="expiredays" value="30">
    记住到永远<input type="radio" name="expiredays" value="100">
    <br>
    <br>
    <input type="submit" value="登陆">
</form>
</body>
</html>
