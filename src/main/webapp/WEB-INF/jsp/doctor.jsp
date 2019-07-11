<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>${title}</title>
</head>
<body>
<h2>Doctor Page!</h2>
<c:if test="${error}">
    <div>Something went wrong!</div>
</c:if>
<c:if test="${idleState}">
    <c:if test="${doneState}">
        <div>Patient done with treatment!</div>
    </c:if>
    <h4>Patient List</h4>
    <table border="2">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Gender</td>
            <td>Complaint</td>
            <td>Status</td>
            <td>Process</td>
        </tr>
        <c:forEach var="patient" items="${patients}">
            <form action="/doProcessPatient?id=${patient.id}" method="post">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.name}</td>
                <td>${patient.gender}</td>
                <td>${patient.complaint}</td>
                <td>${patient.status}</td>
                <td><input type="submit" name="submit" value="Treatment"></td>
            </tr>
            </form>
        </c:forEach>
    </table>
</c:if>
<c:if test="${treatmentState}">
    <h4>Patient on Treatment</h4>
    <form action="/doEndProcessPatient?id=${treatment.id}" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td>:</td>
                <td>${treatment.patientId.name}</td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>:</td>
                <td>${treatment.patientId.gender}</td>
            </tr>
            <tr>
                <td>Complaint</td>
                <td>:</td>
                <td>${treatment.patientId.complaint}</td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" name="submit" value="End Treatment"/></td>
            </tr>
        </table>
    </form>
</c:if>
<c:if test="${medicationState}">
    <h4>Medication List</h4>
    <form action="/doAddMedication?id=${treatmentId}" method="post" modelAttribute="medication">
        <table>
            <tr>
                <td>Medicine Notes</td>
                <td>:</td>
                <td><textarea name="notes"></textarea></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" name="submit" value="Submit Medicine"/></td>
            </tr>
        </table>
    </form>
</c:if>
<div>
    <form action="/doLogout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</div>
</body>
</html>

