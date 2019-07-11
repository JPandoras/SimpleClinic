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
    <table>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td><input type="text" name="patientName"/></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>:</td>
            <td>
                <div><input type="radio" name="patientGender" value="M"/>&nbsp;Male</div>
                <div><input type="radio" name="patientGender" value="F"/>&nbsp;Female</div>
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>:</td>
            <td><input type="text" name="patientAddr"/></td>
        </tr>

    </table>
    <div>
        <form action="/doLogout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</body>
</html>
