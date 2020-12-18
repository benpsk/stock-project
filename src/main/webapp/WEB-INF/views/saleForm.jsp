<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css">
<style>
.error {
		color: red;
}
</style>
</head>
<body>
	<div class="container-fluid pt-4">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container pt-4">
			<div class="jumbotron">
				<h1>Buy Items</h1>
				<br>
				<form:form action="/SpringHibernateStock/addSale" method="post"
					modelAttribute="sale">
					<div class="form-group">
						<form:hidden path="stock.stock_id" value="${stock.stock_id}"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>Stock Name</label> <label class="form-control">${stock.name}</label>
					</div>
					<div class="form-group">
						<label>Price </label>
						<form:hidden path="price" value="${stock.purchase_price}"></form:hidden>
						<label class="form-control">${stock.purchase_price}</label>
					</div>
					<div class="form-group">
						<label>Available Quantity </label> <label class="form-control">${stock.qty}</label>
					</div>
					<br>
					<br>
					<h2>Buyer Information</h2>
					<div class="form-group">
						<label>Date</label>
						<form:input type="date" path="date" class="form-control" />
						<form:errors path="date" cssClass="error" />
					</div>
					<div class="form-group">
						<label>Quantity</label>
						<form:input type="number" min="1" max="${stock.qty}" path="qty"
							class="form-control" />
					</div>
					<form:hidden path="total_amount" class="form-control" />

					<input type="submit" value="Buy" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>