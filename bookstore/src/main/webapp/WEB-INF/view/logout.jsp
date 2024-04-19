<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
 <meta charset="utf-8">
 <title>Logout</title>
</head>
<body>
<h3>Potwierdz wylogowanie</h3>
<c:if test="${(param.error != null) && (not empty SPRING_SECURITY_LAST_EXCEPTION)}">
 <p><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
</c:if>
<form:form  method="post">
        <button type ="submit"> Logout </button>
</form:form>
</body>
</html>