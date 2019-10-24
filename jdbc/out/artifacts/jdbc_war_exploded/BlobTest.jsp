<%@ page import="cn.lv.dao.BaseDao" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.FileOutputStream" %><%--
  Created by IntelliJ IDEA.
  User: lvsihao
  Date: 2019-10-23
  Time: 19:34
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

//    String sql = "insert into users(`username`, `password`, `phone_no`, `address`, `reg_date`, `pic_head`)values(?,?,?,?,?,?)";
//    out.print(request.getSession().getServletContext().getRealPath("/")+"/Resources/111.png");
//    InputStream in = new FileInputStream(request.getSession().getServletContext().getRealPath("/")+"/Resources/111.png");
////    InputStream in = new FileInputStream("/Users/lvsihao/Desktop/111.png");
//    baseDao.iud(sql,"qwer","121212","123123123","us","2019-9-9",in);

    //从数据库中读取文件内blob类型的值
    String sql = "select `pic_head` from users where id=?";
    Blob blob = baseDao.getOneColumnBlob(sql, 18);

    InputStream in = blob.getBinaryStream();
    OutputStream os = new FileOutputStream(request.getSession().getServletContext().getRealPath("/")+"Resources/abc.png");
    byte[] buffer = new byte[1024];
    int len = 0;
    while ((len = in.read(buffer))!=-1){
    	out.println(len);
    	os.write(buffer,0,len);
    }
    os.flush();
    in.close();
    os.close();

%>

</body>
</html>
