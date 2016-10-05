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
		<form:form modelAttribute="systemUser">
			<c:if test="${empty systemUserId}">
				<div class="form-group row">
					<form:label path="systemUserId" class="col-xs-2 col-form-label">
						<spring:message text="User ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="systemUserId" readonly="true"
							 value="${systemUserId}" />
						
					</div>
				</div>
			</c:if>
			<c:if test="${empty address.addressId}">
				<div class="form-group row">
					<form:label path="address.addressId" class="col-xs-2 col-form-label">
						<spring:message text="Address ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="address.addressId" readonly="true"
							 value="${addressId}" />
						
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
				<form:label path="address.state"
					class="col-xs-2 col-form-label">
					<spring:message text="State: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="address.state"
						value="${address.state}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="address.country"
					class="col-xs-2 col-form-label">
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
			<c:if test="${!empty systemUserId}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update User
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty systemUserId}">
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add User
				</button>
			</c:if>
		</form:form>
	</div>
</body>
</html>
