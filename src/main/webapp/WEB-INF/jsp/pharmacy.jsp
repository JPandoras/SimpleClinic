<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>${title}</title>
</head>
<body>
    <h2>Pharmacy Page!</h2>
    <div>
        <form action="/doLogout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</body>
</html>
