<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monthly report</title>
</head>
<body>
	<table>
		<tr>
			<td>Year</td>
			<td>Month</td>
			<td>Revenue</td>
			<td>Expenses</td>
			<td>Sales</td>
			<td>Country</td>
			<td>Unit cost</td>
		</tr>
		<tr>
			<td>${report.year}</td>
			<td>${report.month}</td>
			<c:forEach items="${report.data}" var="data">
				<td>${data}</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>