<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List orders</title>
</head>
<body>
<h2>Books:</h2>
<div>
    <table>
        <tr>
            <th>Date</th>
            <th>Books</th>
            <th>Price</th>
            <th>Status</th>

        </tr>
        <c:forEach var="order" items="${orders}" >
            <tr>
                <td>${order.dateTime}</td>
                <td>
                   <c:forEach var="book" items="${order.books}">
                         ${book.name},
                   </c:forEach>
                </td>
                <td>${order.price}</td>
                <td>${order.status}</td>
                <c:if test="${order.status.equals('NEW')}">
                  <form:form action="${pageContext.request.contextPath}/payment/order" modelAttribute="orderDTO" method="POST">
                   <td><form:hidden path="id" value="${order.id}"/></td>
                   <td><input type="submit" value="PAY"  /></td>
                  </form:form>
                </c:if>
            </tr>
        </c:forEach>
    </table>
   <p>
          <a href="${pageContext.request.contextPath}/ "> return to main page </a>
      </p>
</div>
</body>
</html>