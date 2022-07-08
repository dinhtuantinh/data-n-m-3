package website;

import java.io.IOException;
// import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class profile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// PrintWriter pw=response.getWriter();
			HttpSession ss = request.getSession();
			String j = (String) ss.getAttribute("abc");

			String str2 = request.getParameter("name");
			String str3 = request.getParameter("add");
			String str4 = request.getParameter("state");
			String str5 = request.getParameter("zip");
			String str6 = request.getParameter("country");
			String str7 = request.getParameter("phone");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ws", "root", "jbs13");

			PreparedStatement s = con.prepareStatement("insert into profile values(?,?,?,?,?,?,?)");

			s.setString(1, j);
			s.setString(2, str2);
			s.setString(3, str3);
			s.setString(4, str4);
			s.setString(5, str5);
			s.setString(6, str6);
			s.setString(7, str7);

			s.executeUpdate();
			response.sendRedirect("login.html");

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException d) {
			System.out.println(d);
		}

	}

}
