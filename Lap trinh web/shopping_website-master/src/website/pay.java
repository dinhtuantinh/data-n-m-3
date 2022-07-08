package website;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pay
 */
public class pay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public pay() {
		super();
		// TODO Auto-generated constructor stub
	}

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
			String u = UUID.randomUUID().toString();

			String str1 = request.getParameter("uname");
			PreparedStatement s = con.prepareStatement("Delete from cart where username=?");
			s.setString(1, str1);
			s.executeUpdate();
			PreparedStatement s2 = con
					.prepareStatement("Update order_his set o_number = ? where username=? and o_number=2");
			s2.setString(1, u);
			s2.setString(2, str1);
			s2.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException d) {
			System.out.println(d);
		}
		response.sendRedirect("done.jsp");
	}

}
