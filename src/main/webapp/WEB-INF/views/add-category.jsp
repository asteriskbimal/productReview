<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Add User</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="<c:url value="/resources/js/custom.js" />"></script>
</head>
<body>

	<%@ include file="logout.jsp"%>

	<div id="container" class="col-md-6 col-sm-8">
		<h3 align="center">Category Registration</h3>
		<form:form modelAttribute="category">
			<c:if test="${empty categoryId}">
				<div class="form-group row">
					<form:label path="categoryId" class="col-xs-2 col-form-label">
						<spring:message text="User ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="categoryId" readonly="true"
							 value="${categoryId}" />
						
					</div>
				</div>
			</c:if>
			
			<div class="form-group row">
				<form:label path="categoryName" class="col-xs-2 col-form-label">
					<spring:message text="First Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="categoryName"
						value="${categoryName}" />
				</div>
			</div>
			<c:if test="${!empty categoryId}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update Category
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty categoryId}">
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add Category
				</button>
			</c:if>
		</form:form>
	</div>
</body>
</html>
