package website;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// import java.util.Random;
// import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addtocart
 */

public class addtocart extends HttpServlet {

	public addtocart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public java.sql.Date getCurrentDatetime() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			System.out.println("hi");

			String str1 = request.getParameter("uname");
			String str2 = request.getParameter("type");
			String str3 = request.getParameter("name");
			String str4 = request.getParameter("price");
			String str5 = request.getParameter("s_size");
			String str6 = request.getParameter("quantity");
			int o = 2;
			java.sql.Date date = getCurrentDatetime();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws", "root", "jbs13");

			PreparedStatement s = con.prepareStatement("insert into cart values(?,?,?,?,?,?,?)");

			s.setString(1, str1);
			s.setString(2, str2);
			s.setString(3, str3);
			s.setString(4, str4);
			s.setString(5, str5);
			s.setString(6, str6);
			s.setDate(7, date);
			s.execute();

			PreparedStatement s2 = con.prepareStatement("insert into order_his values(?,?,?,?,?,?,?,?)");

			s2.setString(1, str1);
			s2.setString(2, str2);
			s2.setString(3, str3);
			s2.setString(4, str4);
			s2.setString(5, str5);
			s2.setString(6, str6);
			s2.setDate(7, date);
			s2.setInt(8, o);
			s2.execute();

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException d) {
			System.out.println(d);
		}

		response.sendRedirect("home.jsp");

	}

}
