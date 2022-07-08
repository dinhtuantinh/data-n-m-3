package website;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class profile_edit
 */
public class profile_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public profile_edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ResultSet rs;
		Connection con;

		// String user = null;

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws", "root", "jbs13");
			String j = request.getParameter("uname");
			String str2 = request.getParameter("tele");
			String str1 = request.getParameter("pass");
			String str3 = request.getParameter("address");
			String str4 = request.getParameter("state");
			String str5 = request.getParameter("zip");
			String str6 = request.getParameter("country");

			if (request.getParameter("pc") != null) {
				System.out.println("abc");
				PreparedStatement s = con.prepareStatement("update login set password=? where username=?");
				s.setString(1, str1);
				s.setString(2, j);
				s.executeUpdate();
			} else if (request.getParameter("pe") != null) {
				PreparedStatement s2 = con.prepareStatement("update profile set u_phone=? where username=?");
				s2.setString(1, str2);
				s2.setString(2, j);
				s2.executeUpdate();

			} else {
				PreparedStatement s3 = con.prepareStatement(
						"update profile set u_address=?,u_state=?,u_zipcode=?,u_country=? where username=?");
				s3.setString(1, str3);
				s3.setString(2, str4);
				s3.setString(3, str5);
				s3.setString(4, str6);
				s3.setString(5, j);
				s3.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		response.sendRedirect("profile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
