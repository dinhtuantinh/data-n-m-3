<%@ page import="java.io.*,javax.servlet.http.*,java.sql.*,java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--[if lte IE 6]>
		<style type="text/css" media="screen">
			.tabbed { height:420px; }
		</style>
	<![endif]-->
	

<script type="text/javascript">


	var image1=new Image()
image1.src="bannar/1.jpg"
	var image2=new Image()
image2.src="bannar/2.jpg"
	var image3=new Image()
image3.src="bannar/3.jpg"
	var image4=new Image()
image4.src="bannar/4.jpg"
	var image5=new Image()
image5.src="bannar/5.jpg"
	var image6=new Image()
image6.src="bannar/6.jpg"
	var image7=new Image()
image7.src="bannar/7.jpg"
	var image8=new Image()
image8.src="bannar/8.png"
	var image9=new Image()
image9.src="bannar/9.jpg"
	var image10=new Image()
image10.src="bannar/10.jpg"
	var image11=new Image()
image11.src="bannar/11.jpg"
	var image12=new Image()
image12.src="bannar/12.jpg"
	var image13=new Image()
image13.src="bannar/13.jpeg"
	var image14=new Image()
image14.src="bannar/14.jpg"
	var image15=new Image()
image15.src="bannar/15.jpg"
	var image16=new Image()
image16.src="bannar/16.jpeg"
	var image17=new Image()
image17.src="bannar/17.jpeg"

	var image18=new Image()
image18.src="images/1.jpg"
var image19=new Image()
image19.src="images/2.jpg"
var image20=new Image()
image20.src="images/3.jpg"
var image21=new Image()
image21.src="images/4.jpg"
var image22=new Image()
image22.src="images/5.jpg"
	var image23=new Image()
image23.src="images/6.jpg"
	var image24=new Image()
image24.src="images/7.jpeg"
	var image25=new Image()
image25.src="images/8.jpg"

</script>
</head>


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
<body>
<!-- Top -->
<div id="top">
	
	<div class="shell">
		
		<!-- Header -->
		<div id="header">
			<h1 id="logo"><a href="#">BLING</a></h1>
			<div id="navigation">
				<ul>
				<li><%=j%></li>
				    <li><a href="home.jsp">Home</a></li>
				    <li><a href="profile.jsp">Profile</a></li>
					<li><a href="cart.jsp">Cart (<%=l %>)</a></li>
					<li><a href="logout.jsp" method="get">Logout</a></li></form>
					
					
					
				</ul>
			</div>
			
	

		</div>
		
		<!-- End Header -->
		Apparels&nbsp;<a href="apparels.jsp"><img src="icon/clothing.png" width="30" height="30" align="center" ></img></a>&nbsp;&nbsp;		
		HandBags&nbsp;<a href="bags.jsp"><img src="icon/bag.png" width="30" height="30" align="center" ></img></a>&nbsp;&nbsp;
		Footwear&nbsp;<a href="shoes.jsp"><img src="icon/shoes.png" width="30" height="30" align="center" ></img></a>
		
		<br></br><br><br></br></br>
		 <div class="shell" align="center">
<img src="images/1.jpg" name="slide2" width="250" height="200">
<script type="text/javascript">
<!--
var stepp=18
function slideit2()
{
document.images.slide2.src=eval("image"+stepp+".src")
if(stepp<25)
stepp++
else
stepp=18
setTimeout("slideit2()",8000)
}
slideit2()
//-->
</script>
 
	</div>	
	<br></br>
	<b>ORDER HISTORY</b><br></br>
<div align="left" style="background-color:#000000">	


	<%
	String s1="Select o_number,o_cat,o_name,o_price,o_size,o_quantity,date(o_date) from order_his where username=?";
	PreparedStatement p1=con.prepareStatement(s1);
	p1.setString(1,j);
	p1.execute();

	ResultSet r1=p1.getResultSet();
	while(r1.next())
	{
	String a1=r1.getString(1);
	String a2=r1.getString(2);
	String a3=r1.getString(3);
	String a4=r1.getString(4);
	String a5=r1.getString(5);
	String a6=r1.getString(6);
	String a7=r1.getString(7);
	
	%>
	<table border=".5">
	<tr><td><b style= "font-color:#000000">Order Number:</b></td><td><%=a1%></td></tr>
	<tr><td>Category:</td><td><%=a2%></td></tr>
	<tr><td>Name</td><td><%=a3%></td></tr>
	<tr><td>Price</td><td><%=a4%></td></tr>
	<tr><td>Size</td><td><%=a5%></td></tr>
	<tr><td>Quantity</td><td><%=a6%></td></tr>
	<tr><td>Order Date</td><td><%=a7%></td></tr>
	</table>
	<br>
	<% 
		}
	%></div>
	<br></br>
	<div align="left" style="background-color:#DC143C">	
	<b>PROFILE</b><br><br>
	<%
	String s3="Select username,password from login where username=?";
	PreparedStatement p3=con.prepareStatement(s3);
	p3.setString(1,j);
	p3.execute();

	ResultSet r3=p3.getResultSet();
	while(r3.next())
	{
	String a21=r3.getString(1);
	String a22=r3.getString(2);
	
	%>
<form action="profiledit" method="get">	
<input type="hidden" name="uname" value="<%=j%>">
	<table border="0" style="font-color:Black">		
	<tr><td>USERNAME:</td><td><%=a21%></td></tr>
	<tr><td>PASSWORD:</td><td><input type="text" style="font-size:12pt" name="pass" value="<%=a22%>"></td><td>
	<tr><td><input type="submit" name="pu" value="UPDATE"></td></tr>
	</table></form>
	<br>
	<% 
		}
	%>
	<br><br>
<b>BILLING ADDRESS</b><br></br>
	<%
	String s2="Select u_address,u_state,u_zipcode,u_country,u_phone from profile where username=?";
	PreparedStatement p2=con.prepareStatement(s2);
	p2.setString(1,j);
	p2.execute();

	ResultSet r2=p2.getResultSet();
	while(r2.next())
	{
	String a21=r2.getString(1);
	String a22=r2.getString(2);
	String a23=r2.getString(3);
	String a24=r2.getString(4);
	String a25=r2.getString(5);
	%>
	<form action="profiledit" method="get">
	<input type="hidden" name="uname" value="<%=j%>">
	<table>		
	<tr><td>ADDRESS:</td><td><input type="text" style=" font-size:12pt" name="address" value="<%=a21%>"></td></tr>
	<tr><td>STATE:</td><td><input type="text" style="font-size:12pt" name="state" value="<%=a22%>"></td></tr>
	<tr><td>ZIPCODE:</td><td><input type="text" style="font-size:12pt" name="zip" value="<%=a23%>"></td></tr>
	<tr><td>COUNTRY:</td><td><input type="text" style="font-size:12pt" name="country" value="<%=a24%>"></td></tr>
	<tr><td></table><input type="submit" name="su" value="UPDATE"></td></tr>
	</form>
	<br>
	<% 
		}
	%><form action="profile_update.jsp"></form>


	<div class='shell'>		
			
				</div>
				<div class="shell">
				<!-- Footer -->
				<div id="footer">
					<div class="left">
		
					</div>
					<div class="right">
					</div>
				</div>
				<!-- End Footer -->
				</div>
			</div>
			<!-- End Container -->
			
		</div>
		<!-- End Content -->
		
	</div>
</div>
<!-- End Main -->
		
	
</body>
</html>