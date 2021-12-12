<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Sum project salaries</title>
    <%@ include file="headers.jsp" %>
</head>
<body>
<%@ include file="navigation.jsp" %>
<div class="container">
    <div class="row">
        <h2>Sum project salaries</h2>
    </div>
    <div class="row">
    <div class="form-floating">
            <select class="form-select" id="projectName" name="projectName"
                    value=""
                    aria-label="Floating label select example">
                <option>Select project</option>
                <c:forEach var="element" items="${salaries}">
                      <c:choose>
                         <c:when test="${element.projectName == element.projectName}">
                            <option selected value="${element.projectName}">${element.projectName}</option>
                         </c:when>
                         <c:otherwise>
                            <option value="${element.projectName}">${element.projectName}</option>
                         </c:otherwise>
                      </c:choose>
                </c:forEach>
            </select>
            <label for="projectName">Project</label>
        </div>
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <button onclick="apply()" type="button" class="btn beak_btn">
                  <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-file-check" viewBox="0 0 16 16">
                    <path d="M10.854 6.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 8.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                    <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
                  </svg> Apply
                </button>
            </div>
        </div>
  </div>
</div>
<script>
    let projectName = document.getElementById('projectName');
    function apply() {
     if(projectName.value != null) {
         let url = '/salaries/' + projectName.value;
         window.location.href = url;
      }
    }
</script>
</body>
</html>