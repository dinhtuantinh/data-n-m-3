<%@ page import="java.io.*,javax.servlet.http.*,java.sql.*,java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession ss = request.getSession();
String j=(String)ss.getAttribute("abc");

Class.forName("com.mysql.jdbc.Driver");
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ws","root","jbs13");

PreparedStatement s = con.prepareStatement("Delete from cart where username=?");
s.setString(1,j);
s.executeUpdate();
PreparedStatement s2 = con.prepareStatement("Delete from order_his where username=? and o_number=2");
s2.setString(1,j);
s2.executeUpdate();
response.sendRedirect("home.html");

if (!ss.isNew()) {
    ss.invalidate();
}
%>
</body>
</html>