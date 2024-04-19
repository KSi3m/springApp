<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
 <title>Delete Author</title>
</head>
<body>
Delete Author
<form:form action="deleteAuthor" modelAttribute="author" method="POST">
 <table>
 <td></td>
    <tbody>
    <tr>
        <th>Imie</th>
        <th>Nazwisko</th>
    </tr>
    <tr>
         <form:hidden path="id"/>
         <td><label>${author.name}</label></td>
         <td><label>${author.surname}</label></td>
         <td><input type="submit" value="Delete" class="delete" /></td>
    </tr>
    </tbody>
 </table>
</form:form>
<!-- -wracamy do listy bez zapisu -->
<p>
 <a href="${pageContext.request.contextPath}/authors/list "> return </a>
</p>
</body>
</html>