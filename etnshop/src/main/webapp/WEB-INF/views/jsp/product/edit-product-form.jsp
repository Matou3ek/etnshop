<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<h2>Editing product</h2>
	<form:form method="POST" action="/etnshop/product/update" modelAttribute="product">
		<table>
			<tr style="visibility: hidden">
				<td><form:label path="name">ID </form:label></td>
				<td><form:input path="id" type="text" value="${product.id}"/></td>
			</tr>
			<tr>
				<td><form:label path="name">Name </form:label></td>
				<td><form:input path="name" type="text" value="${product.name}"/></td>
			</tr>
			<tr>
				<td><form:label path="serialNumber">Serial Number </form:label></td>
				<td><form:input path="serialNumber" type="text" value="${product.serialNumber}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" class="btn btn-primary btn-lg"/></td>
			</tr>
		</table>
	</form:form>
	<hr>
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