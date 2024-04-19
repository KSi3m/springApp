<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
 <title>Delete Category</title>
</head>
<body>
Delete Category
<form:form action="deleteCategory" modelAttribute="category" method="POST">
 <table>
 <td></td>
    <tbody>
    <tr>
        <th>Nazwa</th>
    </tr>
    <tr>
         <form:hidden path="id"/>
         <td><label>${category.name}</label></td>
         <td><input type="submit" value="Delete" class="delete" /></td>
    </tr>
    </tbody>
 </table>
</form:form>
<!-- -wracamy do listy bez zapisu -->
<p>
 <a href="${pageContext.request.contextPath}/categories/list "> return </a>
</p>
</body>
</html>