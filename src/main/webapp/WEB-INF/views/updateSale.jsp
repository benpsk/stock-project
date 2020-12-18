<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Sale</title>
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
</head>
<body>
	<div class="container-fluid pt-4">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container pt-4">
			<div class="jumbotron">
				<h1>Update Sale</h1>
				<br>
				<form:form action="/SpringHibernateStock/saveUpdate" modelAttribute="sale">
					<form:hidden path="sale_id"/>
					<div class="form-group">
						<label>Update Stock</label>
						<form:select path="stock.stock_id" class="form-control">
							<c:forEach items="${stock}" var="s">
								<form:option value="${s.stock_id}">${s.name}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="form-group">
						<label>Date</label>
						<form:input type="date" path="date" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Sell Price</label>
						<form:input path="price" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Quantity</label>
						<form:input path="qty" class="form-control" />
					</div>
					<div class="form-group">
						<label>Total Amount</label>
						<form:input path="total_amount" class="form-control" />
					</div>
					<input type="submit" value="Save" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>