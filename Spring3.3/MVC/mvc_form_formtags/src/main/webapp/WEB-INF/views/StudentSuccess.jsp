<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Spring's form tags example</h2>

<table>
<tr>
<td>UserName:</td><td>${studentCommand.userName}</td>
</tr>
<tr>
<td>Address:</td><td>${studentCommand.address}</td>
</tr>
<tr>
<td>Password:</td><td>${studentCommand.password}</td>
</tr>
<tr>
<td>Confirm Password:</td><td>${studentCommand.confirmPassword}</td>
</tr>
<tr>
<td>Receive Newsletter:</td><td>${studentCommand.receiveNewsletter}</td>
</tr>
<tr>
<td>Favorite Subject:</td>
<td>
<c:forEach items="${studentCommand.subject}" var="current">
   [<c:out value="${current}" />]
</c:forEach>
</td>
</tr>
<tr>
<td>Sex:</td><td>${studentCommand.sex}</td>
</tr>
<tr>
<td>Favorite Number :</td><td>${studentCommand.favNumber}</td>
</tr>
<tr>
<td>Country:</td><td>${studentCommand.country}</td>
</tr>
<tr>
<td>Spring Experience:</td><td>${studentCommand.springExperiences}</td>
</tr>
<tr>
<td>Hidden Value :</td><td>${studentCommand.secretValue}</td>
</tr>

</table>

</body>
</html>