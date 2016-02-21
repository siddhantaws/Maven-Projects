<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1></h1>
		<c:url value = "/resources/images/duke.png" var = "dukeLink" />
		Try to access <a href = "<c:out value = '${dukeLink}'/>">this URL</a>.
		<br />
		You should see the Duke Image. 
		<br />
		This is because you set the resource mapping in the /WEB-INF/spring/appServlet/servlet-context.xml file.
		If you disable the resource mapping, you will experience HTTP 404 error.
		<h1></h1>
		<c:url value = "/duke/myimages/Thinking.jpg" var = "thinkingLink" />
		Also try with <a href = "<c:out value = '${thinkingLink}'/>">this other URL</a>.
	</body>
</html>
