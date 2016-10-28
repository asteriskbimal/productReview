<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Add Brand</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="<c:url value="/resources/js/custom.js" />"></script>
</head>
<body>

	<%@ include file="logout.jsp"%>

	<div id="container" class="col-md-6 col-sm-8">
		<h3 align="center">Brand Registration</h3>
		<form:form modelAttribute="productBrand">
			<c:if test="${!empty productBrand.brandId}">
				<div class="form-group row">
					<form:label path="brandId" class="col-xs-2 col-form-label">
						<spring:message text="Brand ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="brandId" readonly="true"
							value="${brandId}" />

					</div>
				</div>
			</c:if>

			<%-- 		<c:if test="${empty brand.products}">
				<div class="form-group row">
					<form:label path="products" class="col-xs-2 col-form-label">
						<spring:message text="Products: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="products" readonly="true"
							value="${null}" />

					</div>
				</div>
			</c:if> --%>

			<div class="form-group row">
				<form:label path="brandName" class="col-xs-2 col-form-label">
					<spring:message text="Brand Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="brandName"
						value="${brandName}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="cat" class="col-xs-2 col-form-label">
					<spring:message text="Select Category: " />
				</form:label>
				<div class="col-xs-8">
					<form:select path="cat">
						<form:options items="${catz}" itemValue="categoryId" />
					</form:select>
				</div>
			</div>
			<c:if test="${!empty productBrand.brandId}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update Brand
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty productBrand.brandId}">
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add Brand
				</button>
			</c:if>
		</form:form>
	</div>
</body>
</html>
