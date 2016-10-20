<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript"
	src="<c:url value="/resources/js/custom.js" />"></script>
</head>
<body>
	<%@ include file="logout.jsp"%>

	<div id="maincontent" class="col-md-8 col-sm-12">
		<h3 align="center">Brand List</h3>
		<c:if test="${!empty brand}">
			<table class="table table-hover table-bordered">
				<tr>
					<th class="col-xs-1">ID</th>
					<th class="col-xs-3">Brand Name</th>
					<th class="col-xs-3">Category Name</th>
					<th colspan="2" class="col-xs-2">Actions</th>
				</tr>
				<c:forEach items="${brand}" var="bran">
					<tr>
						<td class="col-xs-1">${bran.brandId}</td>
						<td class="col-xs-3">${bran.brandName}</td>
						<td class="col-xs-3">${bran.cat.categoryName}</td>
						<td colspan="2"><a
							href="<c:url value='${request.contextPath}/auth/admin/brand/edit?id=${bran.brandId}' />"
							class="label label-success"><span
								class="glyphicon glyphicon-pencil"></span>&nbsp;Edit</a>&nbsp;

							<a
							href="<c:url value='${request.contextPath}/auth/admin/brand/remove?id=${bran.brandId}' />"
							class="label label-danger"><span
								class="glyphicon glyphicon-remove"></span>&nbsp;Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="<c:url value='${request.contextPath}/auth/admin/brand/add' />"
			class="btn btn-primary btn-lg"><span
			class="glyphicon glyphicon-plus"></span>&nbsp;Add Brand </a>&nbsp;&nbsp;
	</div>
</body>
</html>
