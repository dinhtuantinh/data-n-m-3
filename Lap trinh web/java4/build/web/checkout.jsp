<%@ page import="java.io.*,javax.servlet.http.*,java.sql.*,java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<form name="myForm" action="pay" onsubmit="return validateForm()" method="get">
<script type="text/javascript">
function validateForm()
{
var x1=document.forms["myForm"]["ch_num"].value;
if (x1==null || x1=="")
  {
  alert("Card Number must be filled out");
  return false;
  }
var x2=document.forms["myForm"]["ch_name"].value;
if (x2==null || x2=="")
  {
  alert("Card Holder Name must be filled out");
  return false;
  }
var x3=document.forms["myForm"]["ch_cvs"].value;
if (x3==null || x3=="")
  {
  alert("Card CVS Number must be filled out");
  return false;
  }
   
if(document.myForm.ch_num.value.length!=16)
{
    alert("Incorrect Card number");
    return false;
}

if(document.myForm.ch_cvs.value.length!=3)
{
    alert("Incorrect Card CVS number");
    return false;
}
}


</script>
<body>
<div align="center" style="background-color:#DC143C">
MAKE PAYMENT<br><br>

Credit card type:<select name="ch_type"><option>Visa</option><option>MasterCard</option></select><br>

Card number:<input type="text" name="ch_num"><br>

Card holder Name:<input type="text" name="ch_name"><br>

Expire Date:<select name="c_mon"><option>Jan</option><option>Feb</option><option>Mar</option><option>Apr</option><option>May</option>
<option>Jun</option><option>Jul</option><option>Aug</option><option>Sep</option><option>Oct</option><option>Nov</option><option>Dec</option></select>&nbsp;&nbsp;
<select name="year"'><option>2005</option><option>2006</option><option>2007</option><option>2008</option><option>2009</option><option>2010</option>
<option>2011</option><option>2012</option><option>2013</option><option>2014</option><option>2015</option><option>2016</option><option>2017</option></select><br>

CVS Code:<input type="text" name="ch_cvs"><br>
	
<% 

	PrintWriter pw=response.getWriter();
	HttpSession ss=request.getSession();
	String j=(String)ss.getAttribute("abc");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ws","root","jbs13");
	int l=0;
	String s="Select count(c_name) from cart where username=?";
	PreparedStatement p=con.prepareStatement(s);
	p.setString(1,j);
	p.execute();

	ResultSet r=p.getResultSet();
	while(r.next())
	{
	l=r.getInt(1);
	} 
	


%>

	SHIPPING ADDRESS<br><br>
	<table>
	<tr>Name:<input type="text" name="name"></tr><br>
	<tr>Address:<input type="text" name="add" ></tr><br>
	<tr>State:<input type="text" name="state" "></tr><br>
	<tr>ZipCode:<input type="text" name="zip"></tr><br>
	<tr>Country:<input type="text" name="country"></tr><br>
	<tr>Phone:<input type="text" name="phone"></tr><br>
	</table>


<form action="pay" method="get">
<input type="hidden" name="uname" value="<%=j%>">
<input type="submit" value="Pay"> </form>
</form>
</body></div>
</html>