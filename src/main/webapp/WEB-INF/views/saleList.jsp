<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale List</title>
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
.cards {
		display: flex;
		flex-wrap: wrap;
		gap: 1rem;
}

.card {
		display: flex;
		flex-direction: column;
		overflow: hidden;
		background-color: #cacfd2;
}
</style>
</head>
<body>
	<div class="container-fluid pt-4">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<h2 class="pt-4">Sale List</h2>
			<br>
			<div class="cards">
				<c:forEach items="${sale}" var="st" varStatus="row">
					<div class="card" style="width: 260px">
						<div class="card-body">
							<table class="table table-borderless">
								<tbody>
									<tr>
										<td>S. Name</td>
										<td>${st.stock.name }</td>
									</tr>
									<tr>
										<td>S. Date</td>
										<td>${st.date }</td>
									</tr>
									<tr>
										<td>Price</td>
										<td>${st.price }</td>
									</tr>
									<tr>
										<td>T.Amount</td>
										<td>${st.total_amount }</td>
									</tr>
									<tr>
										<td>Quantity:</td>
										<td>${st.qty }</td>
									</tr>
									<tr>
										<td><a href="getSale/${st.sale_id}"
											class="btn btn-warning btn-block">Update</a></td>
										<td><a href="deleteSale/${st.sale_id}"
											class="btn btn-danger btn-block">Delete</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</html>