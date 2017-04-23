<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html ng-app="demo">
	<head>
		<title>Hello AngularJS</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
    	<script type="text/javascript"	src="<c:url value="/resources/js/hello.js" />"></script>
	</head>

	<body>
		<div ng-controller="Hello">
		<ul><li  ng-repeat="x in greeting">
			<p>The ID is {{x.id}}</p>
			<p>The content is {{x.fName}}</p>
			<p>The content is {{x.lName}}</p>
			<p>The content is {{x.phone}}</p>
			</li>
			</ul>
		</div>
		<div id="maincontent" class="col-md-8 col-sm-12" ng-controller="Hello">
		<h3 align="center">User List</h3>
		<c:if test="${!empty users}">
			<table class="table table-hover table-bordered">
				<tr>
					<th class="col-xs-1">ID</th>
					<th class="col-xs-3">First Name</th>
					<th class="col-xs-3">Last Name</th>
					<th class="col-xs-3">Phone</th>
					<th colspan="2" class="col-xs-2">Actions</th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr ng-repeat="x in greeting">
						<td class="col-xs-1">${x.id}</td>
						<td class="col-xs-3">$x.fName}</td>
						<td class="col-xs-3">${x.lName}</td>
						<td class="col-xs-3">${x.phone}</td>
						<td colspan="2"><a
							href="<c:url value='${request.contextPath}/auth/admin/edit?id=${x.id}' />"
							class="label label-success"><span
								class="glyphicon glyphicon-pencil"></span>&nbsp;Edit</a>&nbsp;&nbsp;&nbsp;

							<a
							href="<c:url value='${request.contextPath}/auth/admin/remove?id=${user.id}' />"
							class="label label-danger"><span
								class="glyphicon glyphicon-remove"></span>&nbsp;Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="<c:url value='${request.contextPath}/auth/admin/add' />"
			class="btn btn-primary btn-lg"><span
			class="glyphicon glyphicon-plus"></span>&nbsp;Add User </a>&nbsp;&nbsp;
	</div>
		
	</body>
</html> --%>