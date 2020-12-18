<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Category</title>
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

	<div class="container-fluid p-4">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container">
		<div class="jumbotron">
			<h2>Category List</h2>
			<c:forEach var="category" items="${catList}">
				<ul type="disc"><li>${category.name}</li></ul>
			</c:forEach>
			<br>
			<h2>Add New Category</h2>
			<br>

			<form:form action="addCat" modelAttribute="cat">
				<div class="form-group">
					<label>Category Name </label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" cssClass="error"></form:errors>
				</div>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>