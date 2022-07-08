package website;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sort
 */
public class sort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.sql.Connection con;
		
		try{
			response.setContentType("text/html");
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ws","root","jbs13");
	
		if(request.getParameter("s") !=null) 
		{
			String sql="select i_brand,i_name,i_price,i_img from item where i_cat='shoes' order by i_price asc";
			
		
	}}
		catch(SQLException e)
	{
	System.out.println(e);	
	}
	catch(ClassNotFoundException d)
	{
	System.out.println(d);	
	}
	response.sendRedirect("shoes.jsp");
	}



}
