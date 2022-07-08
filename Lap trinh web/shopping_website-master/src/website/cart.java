package website;

import java.io.IOException;
// import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cart
 */
public class cart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		// ResultSet rs;
		Connection con;

		// String user = null;

		try {

			response.setContentType("text/html");

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws", "root", "jbs13");

			String str1 = request.getParameter("uname");
			String str2 = request.getParameter("name");
			String str3 = request.getParameter("cat");
			String str4 = request.getParameter("s_size");
			String str5 = request.getParameter("quantity");

			if (request.getParameter("d") != null) {
				System.out.println("abc");
				PreparedStatement s = con
						.prepareStatement("Delete from cart where username=? and c_name=? and c_cat=?");
				s.setString(1, str1);
				s.setString(2, str2);
				s.setString(3, str3);
				s.executeUpdate();

				PreparedStatement s2 = con
						.prepareStatement("Delete from order_his where username=? and o_name=? and o_cat=?");
				s2.setString(1, str1);
				s2.setString(2, str2);
				s2.setString(3, str3);
				s2.executeUpdate();

			} else {
				PreparedStatement s3 = con.prepareStatement(
						"Update cart set c_size=?,c_quantity=? where username=? and c_name=? and c_cat=?");
				s3.setString(1, str4);
				s3.setString(2, str5);
				s3.setString(3, str1);
				s3.setString(4, str2);
				s3.setString(5, str3);

				s3.executeUpdate();

				PreparedStatement s4 = con.prepareStatement(
						"Update order_his set o_size=?,o_quantity=? where username=? and o_name=? and o_cat=?");
				s4.setString(1, str4);
				s4.setString(2, str5);
				s4.setString(3, str1);
				s4.setString(4, str2);
				s4.setString(5, str3);

				s4.executeUpdate();

			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException d) {
			System.out.println(d);
		}
		response.sendRedirect("cart.jsp");
	}
}
