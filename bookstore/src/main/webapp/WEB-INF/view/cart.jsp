<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h2>Cart:</h2>
<div>
    <table>
        <tr>
            <th>Nazwa</th>
            <th>Wydawnictwo</th>
            <th>Cena</th>
            <th>Kategoria</th>
            <th>Autorzy</th>
        </tr>
        <tbody>
         <c:forEach var="book" items="${books}">
           <tr>
                 <td><c:out value="${book.name}"/></td>
                 <td><c:out value="${book.publishing}"/> </td>
                 <td><c:out value="${book.price}"/></td>
                 <td><c:out value="${book.category.name}"/></td>
                 <td>
                    <c:forEach var="autor" items="${book.authors}">
                          ${autor.name} ${autor.surname} <br />
                    </c:forEach>
                 </td>
            <td>
            <form:form action="${pageContext.request.contextPath}/cart/delete">
                <input type="hidden" id="bookId" name="bookId" value="${book.id}"/>
                <button type="submit">Usun</button>
            </form:form>

            </td>
           </tr>
         </c:forEach>
        <form:form action="${pageContext.request.contextPath}/order/saveOrder" method="POST">
             <button type="submit">Zrealizuj</button>
        </form:form>
         </tbody>
        </table>
        <p> Price of all books in this cart: ${priceOfCart} </p>
    <div>
      <p>
          <a href="${pageContext.request.contextPath}/books/list "> Return To Booklist  </a>
      </p>
       <p>
           <a href="${pageContext.request.contextPath}/ "> return to main page </a>
       </p>
      </div>
</div>
</body>
</html>