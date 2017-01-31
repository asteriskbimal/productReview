<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Add Product</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="<c:url value="/resources/js/custom.js" />"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>

	function getStates() {
		var str = document.getElementById('mySelect').value;
		$('#mySelect2').empty();

				$.ajax({
					url : "http://localhost:8080/product/auth/admin/ListBrandwithCategory/"+str,
					type : 'GET',
					success : function(data) {
						var html = '';
						var len = data.length;
						for (var i = 0; i < len; i++) {
							html += '<option value="' + data[i].brandId + '">'
									+ data[i].brandName + '</option>';
						}
						$('#mySelect2').append(html);
					}
				});
	}

	$(document).ready(function() {
		$('#mySelect').change(function() {
			getStates();
		});
		
		
	});
</script>
</head>
<body>

	<%@ include file="logout.jsp"%>

	<div id="container" class="col-md-6 col-sm-8">
		<h3 align="center">Product Registration</h3>
		<form:form modelAttribute="product">
			<c:if test="${!empty product.productId}">
				<div class="form-group row">
					<form:label path="productId" class="col-xs-2 col-form-label">
						<spring:message text="Product ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="productId" readonly="true"
							value="${productId}" />

					</div>
				</div>
			</c:if>

			<%-- 		<c:if test="${empty product.products}">
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
				<form:label path="productName" class="col-xs-2 col-form-label">
					<spring:message text="Product Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="productName"
						value="${productName}" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="category" class="col-xs-2 col-form-label">
					<spring:message text="Select Category: " />
				</form:label>
				<div class="col-xs-8">
					<form:select id="mySelect" path="category" items="${category}"
						itemValue="categoryId" multiple="false" />

				</div>
			</div>


			<div class="form-group row">
				<form:label path="productBrand" class="col-xs-2 col-form-label">
					<spring:message text="Select ProductBrand: " />
				</form:label>
				<div class="col-xs-8">
					<form:select id="mySelect2" path="productBrand" itemValue="brandId" multiple="false" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="description" class="col-xs-2 col-form-label">
					<spring:message text="Product Description: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="description"
						value="${description}" />
				</div>
			</div>

			<c:if test="${!empty product.productId}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update Product
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty product.productId}">
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add Product
				</button>
			</c:if>
		</form:form>
	</div>
</body>
</html>
