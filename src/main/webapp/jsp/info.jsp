<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Projects info</title>
    <%@ include file="headers.jsp" %>
</head>
<body>
<%@ include file="navigation.jsp" %>
<div class="container">
    <div class="row">
        <h2>Projects info</h2>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Projects info</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="element" items="${info}">
                <tr>
                    <td><c:out value = "${element.listProjects}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>