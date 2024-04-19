<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<h2>Links:</h2>
<div>


  <sec:authorize access="isAnonymous()">
        <h1>  <a href="${pageContext.request.contextPath}/login" >Login</a>  </h1>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
          <h1>  <a href="${pageContext.request.contextPath}/logout" >Logout</a>  </h1>
          <h2> <a href="${pageContext.request.contextPath}/order/list" > Zamowienia</a> </h2>
  </sec:authorize>
  <sec:authorize access="hasRole('USER')">
          <h2> <a href="${pageContext.request.contextPath}/cart" > Koszyk</a> </h2>
  </sec:authorize>
  <h2> <a href="${pageContext.request.contextPath}/categories/list" >Kategorie</a> </h2>
  <h2> <a href="${pageContext.request.contextPath}/books/list" >Ksiazki</a>  </h2>
  <h2> <a href="${pageContext.request.contextPath}/authors/list" >Autorzy</a>  </h2>


</div>
</body>
</html>