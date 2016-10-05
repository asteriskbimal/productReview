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
		<h3 align="center">User List</h3>
		<c:if test="${!empty systemUser}">
			<table class="table table-hover table-bordered">
				<tr>
					<th class="col-xs-1">ID</th>
					<th class="col-xs-3">First Name</th>
					<th class="col-xs-3">Last Name</th>
					<th class="col-xs-3">City</th>
					<th colspan="2" class="col-xs-2">Actions</th>
				</tr>
				<c:forEach items="${systemUser}" var="user">
					<tr>
						<td class="col-xs-1">${user.systemUserId}</td>
						<td class="col-xs-3">${user.firstName}</td>
						<td class="col-xs-3">${user.lastName}</td>
						<td class="col-xs-3">${user.address.city}</td>
						<td colspan="2"><a
							href="<c:url value='${request.contextPath}/auth/admin/user/edit?id=${user.systemUserId}' />"
							class="label label-success"><span
								class="glyphicon glyphicon-pencil"></span>&nbsp;Edit</a>&nbsp;

							<a
							href="<c:url value='${request.contextPath}/auth/admin/user/remove?id=${user.systemUserId}' />"
							class="label label-danger"><span
								class="glyphicon glyphicon-remove"></span>&nbsp;Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="<c:url value='${request.contextPath}/auth/admin/user/add' />"
			class="btn btn-primary btn-lg"><span
			class="glyphicon glyphicon-plus"></span>&nbsp;Add User </a>&nbsp;&nbsp;
	</div>
</body>
</html>
