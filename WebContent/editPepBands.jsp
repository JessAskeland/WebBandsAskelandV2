<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="editPepBandServlet" method="post">
	Name of Band: <input type="text" name="name of band" value="${bandToEdit.nameOfBand }"><br />
	Number of Members: <input type="text" name="number of members" value="${bandToEdit.numberOfMembers }"><br />
	Location of Band: <input type="text" name="location of band" value="${bandToEdit.locationOfBand }"><br />
	Level of Band: <select name="levelOfBand">
	<option value=1>Elementary</option>
	<option value=2>Junior High</option>
	<option value=3>High School</option>
	</select>
	Playing Position: <select name="playingPosition">
	<option value="Standing">Standing</option>
	<option value="Sitting">Sitting</option>
	</select>
	Event Id: <select name="eventId">
	<option value="1">Girls Basketball</option>
	<option value="2">Boys Basketball</option>
	<option value="3">Football</option>
	<option value="4">Wrestling</option>
	<option value="5">Homecoming</option>
	<option value="6">District Finals</option>
	<option value="7">Red Ribbon Week</option>
	</select>
	
	<input type="hidden" name="bandId" value="${bandToEdit.bandId }">
	<input type="submit" value="Edit Selected Pep Band">
	
</form>
</body>
</html>