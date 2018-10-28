<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List page</title>
    <script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>

</head>


<body>
<h2>List of Records</h2>
<table>
    <tr>
        <td>Id</td><td>Layout id</td><td>Value</td>
    </tr>
    <c:forEach items="${records}" var="record">
        <tr>
            <td>${record.id}</td>
            <td>${record.layoutId}</td>
            <td>${record.value}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="<c:url value='/index' />">Go to form</a>
</body>
</html>