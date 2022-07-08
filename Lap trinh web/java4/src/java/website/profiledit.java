package website;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class profiledit
 */
public class profiledit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profiledit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs;
		Connection con;

		String user = null;

		try
			{


				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ws","root","jbs13");
				String j=request.getParameter("uname");
				String str2=request.getParameter("tele");
				String str1=request.getParameter("pass");
				String str3=request.getParameter("address");
				String str4=request.getParameter("state");
				String str5=request.getParameter("zip");
				String str6=request.getParameter("country");
				
				
		if (request.getParameter("pu") !=null)
		{
			System.out.println("abc");
		PreparedStatement s = con.prepareStatement("update login set password=? where username=?");
		s.setString(1,str1);
		s.setString(2,j);
		s.executeUpdate();
		}
		else if(request.getParameter("pe") != null)
		{
		PreparedStatement s2 = con.prepareStatement("update profile set u_phone=? where username=?");
		s2.setString(1,str2);
		s2.setString(2,j);
		s2.executeUpdate();
	
		}
		else if(request.getParameter("s") != null)
		{
			String stra=request.getParameter("name");
			String strb=request.getParameter("phone");
			String strc=request.getParameter("add");
			String strd=request.getParameter("state");
			String stre=request.getParameter("zip");
			String strf=request.getParameter("country");
			PreparedStatement s4 = con.prepareStatement("insert into profile values (?,?,?,?,?,?,?)");
			s4.setString(1,j);
			s4.setString(2,stra);
			s4.setString(3,strc);
			s4.setString(4,strd);
			s4.setString(5,stre);
			s4.setString(6,strf);
			s4.setString(7,strb);
			s4.execute();
		}
		else  
		{
			PreparedStatement s3 = con.prepareStatement("update profile set u_address=?,u_state=?,u_zipcode=?,u_country=? where username=?");
			s3.setString(1,str3);
			s3.setString(2,str4);
			s3.setString(3,str5);
			s3.setString(4,str6);
			s3.setString(5,j);
			s3.executeUpdate();
		}

		
		
	}
	catch(SQLException e)
	{
	System.out.println(e);	
	}

	response.sendRedirect("Profile2.jsp");
	}



}
