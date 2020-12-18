<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Form</title>
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
				<h1>Add Stock Items</h1>
				<br>
				<form:form action="addStock" method="post" modelAttribute="stock">
				
					<div class="form-group">
						<label>Choose Category</label>
						<form:select path="category.id" class="form-control">
							<c:forEach items="${cat}" var="c">
								<form:option value="${c.id}">${c.name}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="form-group">
						<label>Stock Item</label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<label>Stock Code</label>
						<form:input path="code" class="form-control" />
						<form:errors path="code" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<label>Sale Price </label>
						<form:input type="number" path="sale_price" class="form-control" />
						<form:errors path="sale_price" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<label>Purchase Price</label>
						<form:input type="number" path="purchase_price"
							class="form-control" />
							<form:errors path="purchase_price" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<label>Quantity</label>
						<form:input path="qty" class="form-control" />
						<form:errors path="qty" cssClass="error"></form:errors>
					</div>

					<input type="submit" value="Save" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>