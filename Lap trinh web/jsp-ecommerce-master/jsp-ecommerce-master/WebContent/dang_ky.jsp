<%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("index.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Đăng Ký</div>
			<div class="card-body">
				<form id="dang-ky" action="dang-ky" method="post">
					<div class="form-group">
						<label>Họ và tên</label> 
						<input type="text" name="signup-name" class="form-control" placeholder="Nhập tên" required>
					</div>
					<div class="form-group">
						<label>Địa chỉ Email</label> 
						<input id="email" type="email" name="signup-email" class="form-control" placeholder="Nhập email" required>
					</div>
					<div class="form-group">
						<label>Mật khẩu</label> 
						<input id="password" type="password" name="signup-password" class="form-control" placeholder="Nhập mật khẩu" required>
					</div>
					<div class="form-group">
						<label>Nhập lại mật khẩu</label> 
						<input id="password2" type="password" name="signup- password2" class="form-control" placeholder="Nhập lại mật khẩu" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Đăng ký</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
            document.getElementById('dang-ky').addEventListener('submit', function(){
                function myFunction() {
                    var s = document.getElementById("email").value 
                    tmp1 = "@",
                    tmp2 = ".com";
                    if(s.includes(tmp1) && s.includes(tmp2)) return true;
                    else return false;
                }
                function myPass() {
					var s = document.getElementById("password").value;
					var s2 = document.getElementById("password2").value;
					if(s==s2){
						return true;
					}
					else return false;
				}
                function accept() {
                    alert("Đăng ký thành công");
                    
                }
                function failure() {
                alert("Vui lòng kiểm tra lại Email");
                }
                function failure2() {
                alert("Vui lòng kiểm tra lại mật khẩu");
                }
                if(myFunction() == true && myPass() == true){
                    accept()
                }
                else{
                    if(myFunction() == false){
                        failure()
                    }
                    if(myPass() == false){
                        failure2()
                    }
                }
            });
            </script>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>