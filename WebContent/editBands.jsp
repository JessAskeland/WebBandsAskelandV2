<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: separate;
	border-spacing: 2px;
	padding: 2px;
}
</style>
</head>
<body>
	<form action="editBandServlet" method="post">
		Band Name: <input type="text" name="name of band"
			value="${bandToEdit.nameOfBand }"> 
		Band Location: <input
			type="text" name="location of band"
			value="${bandToEdit.locationOfBand }"> 
		Number of Members: <input
			type="text" name="number of members"
			value="${bandToEdit.numberOfMembers }"> 
		Level of Band: <select name="levelOfBand">
	    <option value=1>Elementary</option>
	    <option value=2>Junior High</option>
	    <option value=3>High School</option>
	    </select>
		<input type="hidden" name="bandId" value="${bandToEdit.bandId }">
		<input type="submit" value="Save Edited Band">
	</form>

</body>
</html>