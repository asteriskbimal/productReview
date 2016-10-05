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
		<h3 align="center">Category List</h3>
		<c:if test="${!empty category}">
			<table class="table table-hover table-bordered">
				<tr>
					<th class="col-xs-1">ID</th>
					<th class="col-xs-3">Category Name</th>
				</tr>
				<c:forEach items="${category}" var="cat">
					<tr>
						<td class="col-xs-1">${cat.categoryId}</td>
						<td class="col-xs-3">${cat.categoryName}</td>
						<td colspan="2"><a
							href="<c:url value='${request.contextPath}/auth/admin/category/edit?id=${cat.categoryId}' />"
							class="label label-success"><span
								class="glyphicon glyphicon-pencil"></span>&nbsp;Edit</a>&nbsp;

							<a
							href="<c:url value='${request.contextPath}/auth/admin/category/remove?id=${cat.categoryId}' />"
							class="label label-danger"><span
								class="glyphicon glyphicon-remove"></span>&nbsp;Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="<c:url value='${request.contextPath}/auth/admin/category/add' />"
			class="btn btn-primary btn-lg"><span
			class="glyphicon glyphicon-plus"></span>&nbsp;Add User </a>&nbsp;&nbsp;
	</div>
</body>
</html>
