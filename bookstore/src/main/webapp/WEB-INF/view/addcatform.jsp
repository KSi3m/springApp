<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
 <title>Categories</title>
</head>
<body>
Add/Update Category
<form:form action="saveCategory" modelAttribute="categoryDTO" method="POST">
 <table>
    <tbody>
    <tr>
         <td><form:hidden path="id"/></td>
         <td><label>nazwa:</label></td>
         <td><form:input path="name" /></td>
         <td><label></label></td>
         <td><input type="submit" value="Save" class="save" /></td>
    </tr>
    </tbody>
 </table>
</form:form>
/<!-- -wracamy do listy bez zapisu -->
<p>
 <a href="${pageContext.request.contextPath}/categories/list "> return </a>
</p>
</body>
</html>