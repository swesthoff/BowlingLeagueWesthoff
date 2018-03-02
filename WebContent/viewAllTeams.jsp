<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Team </title>
</head>
<body>
	<form method="post" action="editTeamServlet">
		<table>
				<tr>
				
				<th>Team Name</th>
				<th>Team Type</th>
				<th>Preferred Night</th>
				
			</tr>
		
			<c:forEach items="${requestScope.allTeams}" var="currentTeam">
				<tr>
					<td><input type="radio" name="id"
						value="${currentTeam.teamId}">${currentTeam.teamId}</td>
					<td>${currentTeam.teamName}</td>
					<td>${currentTeam.teamType}</td>
					<td>${currentTeam.preferredNight}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <input type="submit" value="Delete Selected Team and Players"
			name="doThisToTeam"><br />
		<br /> <input type="submit" value="Add New Team" name="doThisToTeam">
	</form>
	<br />
	<a href="index.html">Return Home</a>
	<br />
	<a href="viewAllPlayersServlet">View All Players</a>
</body>
</html>