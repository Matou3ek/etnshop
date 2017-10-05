<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>etnShop</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<div class="container">
	<h2>Products</h2>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Serial Number</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.serialNumber}</td>
					<td><a class="btn btn-primary btn-lg" href="/etnshop/product/detail/${product.id}" role="button">detail</a>
						<a class="btn btn-primary btn-lg" href="/etnshop/product/edit/${product.id}" role="button">edit</a></td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<p>
		<a class="btn btn-primary btn-lg" href="/etnshop/product/add" role="button">Add product</a>
	</p>
	<p>
		<a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back to homepage</a>
	</p>
	<footer>
		<p>&copy; Etnetera a.s. 2015</p>
	</footer>
</div>

<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>