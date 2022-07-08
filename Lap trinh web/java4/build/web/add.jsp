<%@ page import="java.io.*,java.sql.*,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" %>
<HTML>
<HEAD><TITLE>Display file upload form to the user</TITLE></HEAD>  
<% //  for uploading the file we used Encrypt type of multipart/form-data and input of file type to browse and submit the file %>
  <BODY> 
  <%PrintWriter pw=response.getWriter();
HttpSession ss=request.getSession();
String j=(String)ss.getAttribute("abc");%>
  <FORM  ENCTYPE="multipart/form-data" ACTION="insert_item.jsp" METHOD=POST>
		<br><br><br>
	  <center><table border="2" >
                    <tr><center><td colspan="2"><p align="center"><B>PROGRAM FOR UPLOADING THE FILE</B><center></td></tr>
                    <tr><td><b>Choose the file To Upload:</b></td>
                    <td><INPUT NAME="F1" TYPE="file"></td></tr>
					<tr><td colspan="2"><p align="right"><INPUT TYPE="submit" VALUE="Send File" ></p></td></tr>
             <table>
     </center>      
     </FORM>
</BODY>
</HTML>
