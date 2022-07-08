
<%@page import="cn.techtutorial.connection.DbCon"%>
<%@page import="cn.techtutorial.dao.ProductDao"%>
<%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
<style type="text/css">

.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container my-3" style="min-height: 601px;">
	<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center" style="font-size: 25px;font-weight: 600;">Thêm sản phẩm</div>
			<div class="card-body">
			
				
		<form action="create-product" method="post">
					<div class="form-group">
						<label>Tên</label> 
						<input type="text" name="create-ten" class="form-control" placeholder="Nhập tên" required>
					</div>
					<div class="form-group">
						<label>Loại</label> 
						<input type="text" name="create-loai" class="form-control" placeholder="Nhập loại" required>
					</div>
					<div class="form-group">
						<label>Hãng</label> 
						<input type="text" name="create-hang" class="form-control" placeholder="Nhập hãng" required>
					</div>
					<div class="form-group">
						<label>Gioi tinh</label> 
						<input type="text" name="create-gioitinh" class="form-control" placeholder="Nhập giới tính: Nam/Nữ" required>
					</div>
					<div class="form-group">
						<label>Giá</label> 
						<input type="number" name="create-gia" class="form-control" placeholder="Nhập giá" required>
					</div>
					<div class="form-group">
						<label>Hình ảnh</label> 
						<input type="file" name="create-hinhanh" class="form-control" placeholder="Nhập file" required>
					</div>
					<div class="form-group">
						<label>Mô tả</label> 
						<input type="text" name="create-mota" class="form-control" placeholder="Nhập mô tả" required>
					</div>
				</div>
					<div class="text-center" style="display: flex; align-items: center;justify-content: center;">
						<button type="submit" class="btn btn-primary" style="margin-right: 5px;">Xác nhận</button>
						<button style="
						height:38px;
						width:83px;
						margin-left:5px; 
						background-color: red;
						border-radius: 4px;
						text-align: center;
						
						"
						><a href="/e-cart/index.jsp" style="color: white;text-decoration: none; cursor: pointer;">Quay lại</a></div>
					</div>
				</form>
	</div>
	</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>