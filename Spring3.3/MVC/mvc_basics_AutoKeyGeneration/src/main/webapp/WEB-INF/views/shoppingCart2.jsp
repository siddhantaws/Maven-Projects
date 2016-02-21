<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>shoppingCart2.jsp</title>
</head>
<body>
	<h1>shoppingCart2.jsp</h1>
	<br />
	<h2>From itemList</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Shopper's Name</th>
				<th>Item's Name</th>
				<th>Item's Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${itemList}">
				<tr>
					<td>${user.name}</td>
					<td>${item.itemName}</td>
					<td>${item.price}</td>
				</tr>
			</c:forEach>
			<c:if test="${empty itemList}">
				<tr>
					<td colspan="5">No items found</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<br />
	<h2>From itemList2</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Shopper's Name</th>
				<th>Item's Name</th>
				<th>Item's Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${itemList2}">
				<tr>
					<td>${user.name}</td>
					<td>${item.itemName}</td>
					<td>${item.price}</td>
				</tr>
			</c:forEach>
			<c:if test="${empty itemList2}">
				<tr>
					<td colspan="5">No items found</td>
				</tr>
			</c:if>
		</tbody>
	</table>

</body>
</html>