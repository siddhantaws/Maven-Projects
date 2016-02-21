<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Account</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>

<body>

	<table border="1">
		<tr>
			<th>from "account" model attribute</th>
			<th>Id</th>
			<th>Name</th>
			<th>Balance</th>
			<th>EquityAllocation</th>
			<th></th>
		</tr>
		<tr>
			<th></th>
			<td>${account.id}</td>
			<td>${account.name}</td>
			<td>${account.balance}</td>
			<td>${account.equityAllocation}</td>
		</tr>
	</table>
	<br />
	<table>
		<thead>
			<th>Subject2</th>
		</thead>
		<c:forEach var="subject" items="${subjectList2}">
			<tr>
				<td>${subject}</td>
			</tr>
		</c:forEach>
	</table>
	<td><br /> <a href="..">Home</a>
	</td>
</body>
</html>