<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>List books</title>
</head>
<body>
<h2>Books:</h2>
<div>
    <table>
        <tr>
            <th>Nazwa</th>
            <th>Wydawnictwo</th>
            <th>Cena</th>
            <th>Kategoria</th>
            <th>Autorzy</th>
        </tr>
        <c:forEach var="book" items="${books}" >
            <tr>
                <td>${book.name}</td>
                <td>${book.publishing}</td>
                <td>${book.price}</td>
                <td>${book.category.name}</td>

                <td>
                    <c:forEach var="autor" items="${book.authors}">
                        ${autor.name} ${autor.surname} <br />
                    </c:forEach>
                </td>

            <sec:authorize access="hasRole('ADMIN')">
                <c:url var="update" value="/books/updateBookForm">
                    <c:param name="bookId" value="${book.id}"/>
                </c:url>
                <td><a href="${update}" >update</a> </td>


                <c:url var="delete" value="/books/deleteBookForm">
                    <c:param name="bookId" value="${book.id}"/>
                </c:url>
                <td><a href="${delete}" >delete</a> </td>

            </sec:authorize>


            <sec:authorize access="hasRole('USER')">
                 <td>
                     <form:form action="${pageContext.request.contextPath}/cart/add" method="POST">
                        <input type="hidden" id="bookId" name="bookId" value="${book.id}"/>
                        <input type="hidden" id="quantity" name="quantity" value="1"/>
                          <input type="submit" value="DoKoszyka" class="save" />
                     </form:form>
                 </td>
            </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <sec:authorize access="hasRole('ADMIN')">
        <div>
            <input type="button" value="Add Book"
             onclick="window.location.href='formadd';return false;" />
        </div>
    </sec:authorize>

    <sec:authorize access="hasRole('USER')">
            <h2> <a href="${pageContext.request.contextPath}/cart" > Koszyk</a> </h2>
    </sec:authorize>
      <p>
          <a href="${pageContext.request.contextPath}/ "> return to main page </a>
      </p>
</div>
</body>
</html>