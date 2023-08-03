

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>个人中心</title>
	<link type="text/css" href="css/header.css" rel="stylesheet">
	<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
	<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<body>
<jsp:include page="header.jsp"></jsp:include>
	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
				<input type="hidden" name="${user.id}" value="1">
				<c:if test="${!empty msg }">
					<div style="color:green;" class="alert alert-danger">${msg}</div>
				</c:if>
				<c:if test="${!empty failmsg }">
					<div class="alert alert-danger" style="color: #f30724">${failmsg}</div>
				</c:if>
				<form action="${pageContext.request.contextPath}/ChangeAddressServlet" method="post">
					<div class="register-top-grid">
						<h3>个人中心</h3>
						<h3>收货信息</h3>
						<div class="input" class="form-group">
							<span>收货人<label></label></span>
							<input type="text" name="name" value="${user.name}" placeholder="请输入收货">
						</div>
						<div class="input" class="form-group">
							<span>收货电话</span>
							<input type="text" name="phone" value="${user.phone}" placeholder="请输入收货电话">
						</div>
						<div class="input" class="form-group">
							<span>收货地址</span>
							<input type="text" name="address" value="${user.address}" placeholder="请输入收货地址">
						</div>
						<div class="register-but text-center">
						   <input type="submit" value="提交">
						</div>
					</div>
				</form>
						<hr>
						<h3>安全信息</h3>
				<form method="post" action="${pageContext.request.contextPath}/ChangePasswordServlet">
						<div class="input" class="form-group">
							<span>原密码</span>
							<input type="text" name="password" placeholder="请输入原密码">
						</div>
						<div class="input" class="form-group">
							<span>新密码</span>
							<input type="text" name="passwordNew" placeholder="请输入新密码">
						</div>
						<div class="clearfix"> </div>
						<div class="register-but text-center">
						   <input type="submit" value="提交">
						</div>
				</form>
				<div class="clearfix"> </div>
			</div>
	    </div>
	</div>
	<!--//account-->

</body>
</html>