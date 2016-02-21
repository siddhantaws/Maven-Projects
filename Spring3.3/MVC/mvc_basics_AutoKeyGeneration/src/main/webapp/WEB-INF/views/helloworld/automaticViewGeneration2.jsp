<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>/helloworld/automaticViewGeneration2.jsp</title>
	</head>
	<body>
		<h1>/helloworld/automaticViewGeneration2.jsp</h1>
		<br />
		<h2>From studentList</h2>
		<table border="1">
			<thead>
				<tr>
					<th>Student's Name</th>
					<th>Student's Grade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${studentList}">
					<tr>
						<td>${student.studentName}</td>
						<td>${student.grade}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty studentList}">
					<tr>
						<td colspan="2">No students found</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</body>
</html>