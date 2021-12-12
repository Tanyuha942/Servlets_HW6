<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Java Developers</title>
    <%@ include file="headers.jsp" %>
</head>
<body>
<%@ include file="navigation.jsp" %>
<div class="container">
    <div class="row">
        <h2>Java Developers</h2>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Java developers</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="element" items="${java}">
                <tr>
                    <td><c:out value = "${element.developerName}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>