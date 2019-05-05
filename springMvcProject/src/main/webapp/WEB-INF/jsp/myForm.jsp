<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Select a file to upload:</h1>
	<form action="handleForm" method="post" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="submit"/>
	</form>
</body>
</html>