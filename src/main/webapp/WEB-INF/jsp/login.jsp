<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>${title}</title>
</head>
<body>
    <c:if test="${error}">
        <div>Invalid username and password.</div>
    </c:if>
    <c:if test="${logout}">
        <div>You have been logged out.</div>
    </c:if>
    <form action="/doLogin" method="post">
        <table>
            <tr>
                <td>Username</td>
                <td>:</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td>:</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td colspan="3"><input name="submit" type="submit" value="Login"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
