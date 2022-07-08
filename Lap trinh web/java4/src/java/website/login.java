package website;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ResultSet rs;
		Connection con;

		String user = null;

			try
			{
				response.setContentType("text/html");
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ws","root","jbs13");
			
				
				String sql="Select username,password from login";
				
				Statement s=con.createStatement();
				s.executeQuery(sql);
				rs=s.getResultSet();
				int x=0;
				String str1=request.getParameter("user");
				String str2=request.getParameter("password");
				
				while(rs.next())
				{	user=rs.getString("username");
					String pass=rs.getString("password");
			
					
					if(str1.equals(user)&&str2.equals(pass))
				{
					
				x=1;
				HttpSession ss=request.getSession();
				ss.setAttribute("abc",user);
				response.sendRedirect("home.jsp");
			
						
				}
					
			}
				if(x==0)
				{
				response.sendRedirect("home.html");
				}
				
			
				rs.close();
				
				s.close();
				
				
				
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

