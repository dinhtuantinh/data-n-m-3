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
import cn.techtutorial.dao.ProductDao;
import cn.techtutorial.dao.UserDao;
import cn.techtutorial.model.User;

@WebServlet("/create-product")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String name =  request.getParameter("create-ten");
			String loai =  request.getParameter("create-loai");
			String hang =  request.getParameter("create-hang");
			String gioitinh =  request.getParameter("create-gioitinh");
			Double gia =  Double.parseDouble(request.getParameter("create-gia"));
			String hinhanh =  request.getParameter("create-hinhanh");
			String mota =  request.getParameter("create-mota");

			ProductDao check = new ProductDao(DbCon.getConnection());
			
				check.CreateProduct(name,loai,hang,gioitinh,gia,hinhanh,mota);
				response.sendRedirect("index.jsp");

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 
	}
}


