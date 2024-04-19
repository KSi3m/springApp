<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
 <title>Authors</title>
</head>
<body>
Add/Update Author
<form:form action="saveAuthor" modelAttribute="authorDTO" method="POST">
 <table>
    <tbody>
    <tr>
         <td><form:hidden path="id"/></td>
         <td><label>imie:</label></td>
         <td><form:input path="name" /></td>
         <td><label>nazwisko:</label></td>
         <td><form:input path="surname" /></td>
         <td><label></label></td>
         <form:hidden path="booksIds"/>
         <td><input type="submit" value="Save" class="save" /></td>
    </tr>
    </tbody>
 </table>
</form:form>
/<!-- -wracamy do listy bez zapisu->
<p>
 <a href="${pageContext.request.contextPath}/authors/list "> return </a>
</p>
</body>
</html>