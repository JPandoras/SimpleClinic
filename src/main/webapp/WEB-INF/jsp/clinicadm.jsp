<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>${title}</title>
</head>
<body>
    <h2>Clinic Administration Page!</h2>
    <c:if test="${error}">
        <div>Something went wrong!</div>
    </c:if>
    <c:if test="${success}">
        <div>Data added!</div>
    </c:if>
    <form action="/doSubmitEntry" method="post" modelAttribute="patient">
    <table>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>:</td>
            <td>
                <div><input type="radio" name="gender" value="M"/>&nbsp;Male</div>
                <div><input type="radio" name="gender" value="F"/>&nbsp;Female</div>
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>:</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>Complaint</td>
            <td>:</td>
            <td><textarea name="complaint"></textarea></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Submit" name="submit"/></td>
        </tr>
    </table>
    </form>
    <div>
        <form action="/doLogout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</body>
</html>
