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
			<div class="card-header text-center" style="font-size: 25px;font-weight: 600;">Thông tin nhận hàng</div>
			<div class="card-body">
			
				
		<form action="cart-check-out" method="post">
					<div class="form-group">
						<div>Họ và tên</div> 
						<div> ${sessionScope.acc.name }</div>
					</div>
					<div class="form-group">
						<label>Số điện thoại</label> 
						<input type="text" name="checkout-sdt" class="form-control" placeholder="Nhập số điện thoại">
					</div>
					<div class="form-group">
						<label>Địa chỉ</label> 
						<input type="text" name="checkout-diachi" class="form-control" placeholder="Nhập địa chỉ">
					</div>
			<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%= dcf.format(c.getPrice())%> $</td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
				<div style="display: flex;">
				<div style="padding-left: 12px; font-weight: 600">Tổng tiền</div>
				<div style="color: red; padding-left: 318px; font-weight: 600">${(total>0)?dcf.format(total):0} $</div>
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
						><a href="/e-cart/cart.jsp" style="color: white;text-decoration: none; cursor: pointer;">Quay lại</a></div>
					</div>
				</form>
	</div>
	</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>