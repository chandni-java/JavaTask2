<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button-container {
	text-align: center;
	margin-top: 20px; /* add margin to move the button down */
}

.beige-btn {
	background-color: #F5DEB3; /* Beige color */
	color: #333; /* Text color */
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 4px;
	transition: background-color 0.3s ease-in-out;
	margin: auto;
}

.beige-btn:hover {
	background-color: #D2B48C; /* Lighter beige on hover */
}

body {
	background-color: #f7f7f7;
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.3);
	justify-content: center;
}

.container {
	width: 95%;
	margin: auto;
	padding: 20px;
	background-color: #ffffff;
	box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.3);
	justify-content: center;
}

table {
	border-collapse: collapse;
	width: 100%;
}

.center-align {
	text-align: center;
}

th, td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #2ecc71;
	color: white;
}

tr:hover {
	background-color: #f2f2f2;
}

.checkbox-col {
	width: 30px;
}

.buffering-gif {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 9999;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="center-align">
		<table>
			<thead>
				<tr>
					<th class="center-align">These records are already present in
						OP environment</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${sysid}">
					<tr>
						<td class="center-align">${item}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<div class="button-container">
		<button class="beige-btn" type="submit" value="submit" name="saveit">OK</button>
	</div>
</body>
</html>