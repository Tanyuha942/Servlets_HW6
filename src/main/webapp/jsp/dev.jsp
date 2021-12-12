<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Project developers</title>
    <%@ include file="headers.jsp" %>
</head>
<body>
<%@ include file="navigation.jsp" %>
<% com.goit.model.ProjectDeveloper develop = (com.goit.model.ProjectDeveloper) request.getAttribute("develop"); %>
<div class="container">
    <div class="row">
        <h2>Project developers</h2>
    </div>
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/devs" type="button" class="btn beak_btn">
                <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-arrow-left-square" viewBox="0 0 16 16">
                  <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm11.5 5.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                </svg>
                Project developers</a>
            </div>
        </div>
    </div>
    <div class="row">
        <table class="table">
          <thead>
          <tr>
              <th scope="col">Project name</th>
              <th scope="col">Developers</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="element" items="${dev}">
                <tr>
                    <td><c:out value = "${element.projectName}"/></td>
                    <td><c:out value = "${element.developer}"/></td>
                </tr>
          </c:forEach>
          </tbody>
        </table>
</div>
</body>
</html>