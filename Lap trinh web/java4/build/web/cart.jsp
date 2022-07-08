<%@ page import="java.io.*,javax.servlet.http.*,java.sql.*,java.util.Date" language="java"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<script type="text/javascript">
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
<body>
<!-- Top -->

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
					<li><input type="hidden" name="uname" value="<%=j%>"></li>	
				</ul>
					
					
				</ul>
			</div>
			
	

		</div>
		
	
		<!-- End Header -->
		Apparels&nbsp;<a href="apparels.jsp"><img src="icon/clothing.png" width="30" height="30" align="center" ></img></a>&nbsp;&nbsp;		
		HandBags&nbsp;<a href="bags.jsp"><img src="icon/bag.png" width="30" height="30" align="center" ></img></a>&nbsp;&nbsp;
		Footwear&nbsp;<a href="shoes.jsp"><img src="icon/shoes.png" width="30" height="30" align="center" ></img></a>
		
		<br></br>	</div>
	
<br><br><br><br>
<div class="shell" align="center">
<table align="center">		
<tr><td>
<%

String str1=request.getParameter("name");
String sql11="select c_cat,c_name,c_price,c_size,c_quantity from cart where username='"+j+"'";
Statement stmt11 = con.createStatement();
ResultSet rs = stmt11.executeQuery(sql11);
while (rs.next())
	
{   String ab11=rs.getString(1);
	String ab12=rs.getString(2);
	String ab13=rs.getString(3);
	String ab14=rs.getString(4);
	String ab15=rs.getString(5);
	System.out.println(ab11);
	if(ab11.equals("bags"))
	{
%><form action="cart" method="get">
<table border=".5" align="center">		

<input type="hidden" name="uname" value="<%=j%>">
<td width="200">
<input type="text" style="background-color:#DC143C;border: none; font-size: 14pt" name="cat" value="<%=ab11%>"></td><td>
<input type="text" style="background-color:#DC143C;border: none; font-size: 14pt" name="name" value="<%=ab12%>"></td><td>
<input type="text" style="background-color:#DC143C;border: none; font-size:14pt" name="price" value="<%=ab13%>"></td><td>
<select name="s_size"><option>--</option></select></td><td>
<select name="quantity"><option><%=ab15%></option><option>1</option><option>2</option><option>3</option><option>4</option></select></td><td>
<input type="submit" name="d" value="Delete"></td><td>
<input type="submit" name="u" value="Update" >
</td></tr>
</table></form>
<% 
	}
else if(ab11.equals("shoes"))
{
	%><form action="cart" method="get">
	<table border=".5" align="center">		
<input type="hidden" name="uname" value="<%=j%>">

	<td width="200">
	<input type="text" style="background-color:#DC143C;border: none; font-size: 14pt" name="cat" value="<%=ab11%>"></td><td>
	<input type="text" style="background-color:#DC143C;border: none; font-size: 14pt" name="name" value="<%=ab12%>"></td><td>
	<input type="text" style="background-color:#DC143C;border: none; font-size:14pt" name="price" value="<%=ab13%>"></td><td>
	<select name="s_size"><option><%=ab14%></option><option>6</option><option>6.5</option><option>7</option><option>7.5</option><option>8</option></select></td><td>
	<select name="quantity"><option><%=ab15%></option><option>1</option><option>2</option><option>3</option><option>4</option></select></td><td>
	<input type="submit" name="d" value="Delete"></td><td>
	<input type="submit" name="u" value="Update" >
	</td></tr>
	</table></form>
	<% 
		}
else if(ab11.equals("apparels"))
{

	%>
	<form action="cart" method="get">
	<table border=".5" align="center">		
<input type="hidden" name="uname" value="<%=j%>">

	<td width="200">
	<input type="text" style="background-color:#DC143C;border: none; font-size: 14pt" name="cat" value="<%=ab11%>"></td><td>
	<input type="text" style="background-color:#DC143C;border: none; font-size: 14pt" name="name" value="<%=ab12%>"></td><td>
	<input type="text" style="background-color:#DC143C;border: none; font-size:14pt" name="price" value="<%=ab13%>"></td><td>
	<select name="s_size"><option><%=ab14%></option><option>XSmall</option><option>Small</option><option>Medium</option><option>Large</option><option>XLarge</option></select></td><td>
	<select name="quantity"><option><%=ab15%></option><option>1</option><option>2</option><option>3</option><option>4</option></select></td><td>
	<input type="submit" name="d" value="Delete"></td><td>
	<input type="submit" name="u" value="Update" >
	</td></tr>
	</table></form>
	<% 
	}	}
%>
</td></tr></table>
<br>
<%
float t=0;
 String t1="select sum(c_price) from cart where username=?";
 PreparedStatement p1=con.prepareStatement(t1);
 p1.setString(1,j);
 p1.execute();

 ResultSet r1=p1.getResultSet();
 while(r1.next())
 {
 t=r1.getFloat(1);
 }
 %>
<p align="right"><b>TOTAL:</b>&nbsp;<input type="text" style="background-color:#DC143C;border: none; font-size:14pt" name="total" value="$<%=t%>">
<br><form action="checkout.jsp" method="get"><input type="submit" value="CHECKOUT"></form></p>
<br><br>
<a href="home.jsp"><u>Continue Shopping</u></a> &nbsp;

</div>
<br><br><br><br>
<div class="shell">
<img src="images/1.jpg" name="slide2" width="250" height="200" align="right" >
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
	<div class='shell'>		
				<!-- Brands -->
				<div class="brands">
					<h3>Brands</h3>
					<div class="logos">
				
						<img src="brands/aldo.jpg" alt="" width="100" height="100" />
						<img src="brands/coach.jpeg" alt="" width="100" height="100" />
						<img src="brands/fr21.jpeg" alt="" width="100" height="100" />
						<img src="brands/mk.gif" alt="" width="100" height="100" />
						<img src="brands/sm.png" alt="" width="100" height="100" />


					    
					</div>
				</div>
				<!-- End Brands -->
				</div><br><br><br>
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