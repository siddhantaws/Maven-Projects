<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
<h2>Spring's form tags example</h2>

<form:form modelAttribute="studentCommand" method="POST" >

	<form:errors path="*" cssClass="errorblock" element="div" />

	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="userName" /></td>
			<td><form:errors path="userName" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><form:textarea path="address" /></td>
			<td><form:errors path="address" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Confirm Password :</td>
			<td><form:password path="confirmPassword" /></td>
			<td><form:errors path="confirmPassword" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Subscribe to newsletter? :</td>
			<td><form:checkbox path="receiveNewsletter" /></td>
			<td><form:errors path="receiveNewsletter" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Favorite Subject:</td>
			<td><form:checkboxes items="${subjectList}"
				path="subject" /></td>
			<td><form:errors path="subject" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Sex :</td>
			<td><form:radiobutton path="sex" value="M" />Male <form:radiobutton
				path="sex" value="F" />Female</td>
			<td><form:errors path="sex" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Choose a number:</td>
			<td><form:radiobuttons path="favNumber" items="${numberList}" />
			</td>
			<td><form:errors path="favNumber" cssClass="error" /></td>
		</tr>

		<tr>
			<td>Country:</td>
			<td><form:select path="country">
				<form:option value="NONE" label="--- Select ---" />
				<form:options items="${countryList}" />
			</form:select></td>
			<td><form:errors path="country" cssClass="error" /></td>
		</tr>

		<tr>
			<td>Spring Experience:</td>
			<td><form:select path="springExperiences" items="${springExperiencesList}"
				multiple="true" /></td>
			<td><form:errors path="springExperiences" cssClass="error" /></td>
		</tr>


		<form:hidden path="secretValue" />

		<tr>
			<td colspan="3"><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>