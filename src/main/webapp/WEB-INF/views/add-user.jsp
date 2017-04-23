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
		<h3 align="center">User Registration</h3>
		<form:form modelAttribute="systemUser" enctype="multipart/form-data">
			<c:if test="${!empty systemUser.systemUserId}">
				<div class="form-group row">
					<form:label path="systemUserId" class="col-xs-2 col-form-label">
						<spring:message text="User ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="systemUserId"
							readonly="true" value="${systemUserId}" />

					</div>
				</div>
			</c:if>
			<div class="form-group row">
				<form:label path="firstName" class="col-xs-2 col-form-label">
					<spring:message text="First Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="firstName"
						value="${firstName}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="lastName" class="col-xs-2 col-form-label">
					<spring:message text="Last Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="lastName"
						value="${lastName}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="userName" class="col-xs-2 col-form-label">
					<spring:message text="Username: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="userName"
						value="${userName}" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="address.city" class="col-xs-2 col-form-label">
					<spring:message text="City: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="address.city"
						value="${address.city}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="address.state" class="col-xs-2 col-form-label">
					<spring:message text="State: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="address.state"
						value="${address.state}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="address.country" class="col-xs-2 col-form-label">
					<spring:message text="country: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="address.country"
						value="${address.country}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="address.zip" class="col-xs-2 col-form-label">
					<spring:message text="zip Code: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="address.zip"
						value="${address.zip}" />
				</div>

			</div>
			<div class="form-group row">
				<form:label path="files" class="col-xs-2 col-form-label">
					<spring:message text="Upload File: " />
				</form:label>
				<div class="col-xs-8" id="filesUpload">		
						<form:input class="form-control" path="files" type="file" />
				</div>
				<!--  <input type="button" id="addFile" class="btn btn-success" value="Add More files">-->
			</div>
			<c:if test="${!empty systemUser.systemUserId}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update User
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty systemUser.systemUserId}">
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add User
				</button>
			</c:if>
		</form:form>
	</div>
</body>
</html>
