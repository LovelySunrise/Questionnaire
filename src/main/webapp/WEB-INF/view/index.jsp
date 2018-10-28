<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Start page</title>
    <script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/script.js' />" type="text/javascript"></script>
    <link type="text/css" href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" />
</head>


<br>
${generatedHtmlLayout}
<br>
<a style="display: block" href="<c:url value='/list' />">Go to records</a>
</body>
</html>