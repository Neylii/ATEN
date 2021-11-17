<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Welcome to ATEN Webstore</h1>

<ul>
    <c:forEach items="${articles}" var="article">
        <li>${article}</li>
    </c:forEach>
</ul>