
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Monthly Report</title>
</head>
<h2>${msg}</h2>
<form method="POST" action="/excel/table">
	<h3>Select year:</h3>
	<select name="year">
		<c:forEach items="${yearList}" var="year">
			<option value="${year}">${year}</option>
		</c:forEach>
	</select>
	<h3>Select month:</h3>
	<select name="month">
		<c:forEach items="${monthList}" var="month">
			<option value="${month}">${month}</option>
		</c:forEach>
	</select>
	<p>
		<input type="submit" value="Submit" />
	</p>
</form>
<p>
	<button onclick="window.location.href='/excel/vlookup'">Vlookup</button>
</p>
</body>
</html>