<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Create an account!</h1>

<form:form modelAttribute="form">
    <form:errors path="" element="div" />
    <div>
        <form:label path="username">Username</form:label>
        <form:input path="username" />
        <form:errors path="username" />
    </div>
    <div>
        <form:label path="password">Password</form:label>
        <form:input path="password" />
        <form:errors path="password" />
    </div>
    <div>
        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" />
        <form:errors path="firstName" />
    </div>
    <div>
        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" />
        <form:errors path="lastName" />
    </div>
    <div>
        <input type="submit" />
    </div>
</form:form>
</body>
</html>