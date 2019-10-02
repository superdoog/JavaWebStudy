<%@ page import="java.sql.Connection" %>
<%@ page import="cn.lv.jdbc.DBUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        //获取数据库连接
        Connection conn = DBUtils.getConnection();
        //准备插入语句
        String sql = "INSERT INTO users(username,password,phone_no,address,reg_date)"+
                "VALUES('xiaobai', '123456','12345678901','zhuhai','2019-1-1');";
        //获取sql到Statement对象
        Statement statement = conn.createStatement();
        int count = statement.executeUpdate(sql);//执行sql，返回结果，返回影响到到数据记录条数
        //关闭Statement
        statement.close();
        //关闭数据连接
        conn.close();

        if (count > 0){
            out.println("插入成功");
        }
    %>

</body>
</html>
