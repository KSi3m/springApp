<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Categories list</title>
</head>
<body>
<h2>Books:</h2>
<div>
    <table>
        <tr>
            <th>Nazwa</th>
        </tr>
        <c:forEach var="categories" items="${categories}" >
            <tr>
                <td>${categories.name}</td>
                <sec:authorize access="hasRole('ADMIN')">
                <c:url var="update" value="/categories/updateCategoryForm">
                     <c:param name="categoryId" value="${categories.id}"/>
                </c:url>
                <td><a href="${update}" >update</a> </td>

                <c:url var="delete" value="/categories/deleteCategoryForm">
                     <c:param name="categoryId" value="${categories.id}"/>
                </c:url>
                <td><a href="${delete}" >delete</a> </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <sec:authorize access="hasRole('ADMIN')">
      <div>
            <input type="button" value="Add Category"
             onclick="window.location.href='add';return false;" />
      </div>
    </sec:authorize>
       <p>
              <a href="${pageContext.request.contextPath}/ "> return to main page </a>
          </p>
</div>
</body>
</html>