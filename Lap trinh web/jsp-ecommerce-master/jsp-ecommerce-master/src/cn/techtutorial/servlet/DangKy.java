package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.techtutorial.connection.DbCon;
/*import cn.techtutorial.dao.CheckEmailDao;*/
import cn.techtutorial.dao.UserDao;
import cn.techtutorial.model.User;

@WebServlet("/dang-ky")
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String name =  request.getParameter("signup-name");
			String email = request.getParameter("signup-email");
			String password = request.getParameter("signup-password");

			UserDao check = new UserDao(DbCon.getConnection());
			User checkemail = check.UserEmail(email);
			if (checkemail == null) {
				check.UserSignUp(name,email,password);
				response.sendRedirect("login.jsp");
			} else {
				out.println("email da duoc su dung");
				response.sendRedirect("dang_ky.jsp");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}


