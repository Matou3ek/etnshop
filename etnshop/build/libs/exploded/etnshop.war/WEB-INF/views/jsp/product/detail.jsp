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
	<h2>Detail</h2>
	<h4>ID: ${product.id}</h4
	<h4>Name: ${product.name}</h4>
	<h4>Serial Number: ${product.serialNumber}</h4>
	<p>
		<a class="btn btn-primary btn-lg" href="/etnshop/product/edit/${product.id}" role="button">Edit product</a>
	</p>
	<hr>
	<p>
		<a class="btn btn-primary btn-lg" href="/etnshop/product/list" role="button">Back to products</a>
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