package website;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {
	 public register() {
	        super();
	       
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
		

		
			
			String str4=request.getParameter("uname");
			String str5=request.getParameter("pword");
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ws","root","jbs13");
		
			

		
		PreparedStatement s = con.prepareStatement("insert into login values(?,?)");
		
	
		s.setString(1,str4);
		s.setString(2,str5);		
	
		
		s.executeUpdate();
		response.sendRedirect("login.html");
		
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException d)
		{
			System.out.println(d);
		}
		

		
	}
	
}
	
