<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>Account Not Available</title>
</head>

<body>
If you see this page, the error handling scheme in this application
worked as expected. (Inside the index.jsp, it is trying to access
"./account/3", that does not exist.

<br/>
<br/>

The account number ${exception.resourceId} is not available on
<fmt:formatDate value="${exception.date}" pattern="yyyy-MM-dd" /> 
</body>
</html>
