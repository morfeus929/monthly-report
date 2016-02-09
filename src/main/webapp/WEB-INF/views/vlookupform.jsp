<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vlookup formula</title>
</head>
<body>
	<h3>${msg}</h3>
	<br>
	<form method="POST" action="/excel/vlookup">
		<input name="value" type="text" size="40" placeholder="lookup value"><br>
		<br> <input name="range" type="text" size="40" placeholder="table array"><br>
		<br> <input name="column" type="text" size="40" placeholder="col index num"><br>
		<br> range lookup<br> <label><input name="rangelookup" type="radio" value="FALSE" checked> false</label> <label><input
			name="rangelookup" type="radio" value="TRUE"> true</label><br> <input type="submit" />
		<p>
			<input type="button" value="Back" onclick="window.history.back()" />
		</p>
	</form>
</body>
</html>