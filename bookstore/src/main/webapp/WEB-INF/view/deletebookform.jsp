<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
 <title>Delete Book</title>
</head>
<body>
Delete Book
<form:form action="deleteBook" modelAttribute="book" method="POST">
 <table>
 <td></td>
    <tbody>
    <tr>
        <th>Nazwa</th>
        <th>Wydawnictwo</th>
        <th>Cena</th>
    </tr>
    <tr>
         <form:hidden path="id"/>
         <td><label>${book.name}</label></td>
         <td><label>${book.publishing}</label></td>
         <td><label>${book.price}</label></td>
         <td><input type="submit" value="Delete" class="delete" /></td>
    </tr>
    </tbody>
 </table>
</form:form>
<!-- -wracamy do listy bez zapisu -->
<p>
 <a href="${pageContext.request.contextPath}/books/list "> return </a>
</p>
</body>
</html>