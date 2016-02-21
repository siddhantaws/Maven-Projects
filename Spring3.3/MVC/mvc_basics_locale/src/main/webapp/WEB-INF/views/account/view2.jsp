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
				<th>Id</th>
				<th>Name</th>
				<th>Balance</th>
				<th>EquityAllocation</th>
				<th></th>
			</tr>
			<tr>
				<td>${account.id}</td>
				<td>${account.name}</td>
				<td>${account.balance}</td>
				<td>${account.equityAllocation}</td>
			</tr>
		</table>
		<br/>
		<a href="..">Home</a>
	</body>
</html>