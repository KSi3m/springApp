<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Authors list</title>
</head>
<body>
<h2>Authors:</h2>
<div>
    <table>
        <tr>
            <th>Imie</th>
            <th>Nazwisko</th>
        </tr>
        <c:forEach var="authors" items="${authors}" >
            <tr>
                <td>${authors.name}</td>
                <td>${authors.surname}</td>

            <sec:authorize access="hasRole('ADMIN')">
                <c:url var="update" value="/authors/updateAuthorForm">
                       <c:param name="authorId" value="${authors.id}"/>
                </c:url>
                <td><a href="${update}" >update</a> </td>

                <c:url var="delete" value="/authors/deleteAuthorForm">
                      <c:param name="authorId" value="${authors.id}"/>
                </c:url>
                <td><a href="${delete}" >delete</a> </td>
            </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <sec:authorize access="hasRole('ADMIN')">
        <div>
            <input type="button" value="Add Author"
             onclick="window.location.href='add';return false;" />
        </div>
    </sec:authorize>
    <p>
        <a href="${pageContext.request.contextPath}/ "> return to main page </a>
    </p>

</div>
</body>
</html>