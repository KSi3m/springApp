<%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 15.05.2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>books</title>
</head>
<body>
ADD BOOK
<form:form action="saveBook" modelAttribute="bookDTO" method="POST">


   
    <td><form:hidden path="id"/></td>

    <table>
        <tbody>
        <tr>
            <td><label>nazwa:</label></td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td><label>wydawnictwo:</label></td>
            <td><form:input path="publishing" /></td>
        </tr>

        <tr>
            <td><label>cena:</label></td>
            <td><form:input path="price" /></td>
        </tr>
        <tr>

            <td>
                <form:select path="categoryid">
                    <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                </form:select>
            </td>

        </tr>

        <tr>
            <td>
                 <form:select path="authorsIds">
                       <form:options items="${authors}" itemValue="id" itemLabel="surname"/>
                 </form:select>
            </td>

            <td>
                <form:select path="ordersIds" style="display: none;">
                     <form:options items="${orders}" itemValue="id" itemLabel="id"/>
                </form:select>
               </td>
            <td>

            </td>


        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save"  /></td>
        </tr>


        </tbody>
    </table>


</form:form>


<p>
    <a href="${pageContext.request.contextPath}/books/list "> return  </a>
</p>
</body>
</html>
