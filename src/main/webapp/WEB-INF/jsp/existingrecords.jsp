<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button-link {
	background-color: #F5DEB3; /* Beige color */
	color: #333; /* Text color */
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 4px;
	transition: background-color 0.3s ease-in-out;
	margin: auto; /* Set a maximum width as desired */
	text-decoration: none;
}

.button-link:hover {
	background-color: #D2B48C; /* Lighter beige on hover */
}

.button-container {
	text-align: center;
	margin-top: 20px;
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
	width: 100%;
	padding: 10px;
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
		<h1 style="align-content: center">These record(s) are already
			present in OP Environment</h1>
		<table>
			<thead>
				<tr>
					<th>Sr No.</th>
					<th>Sys Class Name</th>
					<th>Sys_id</th>
					<th>Delivery Date</th>
					<th>Purchase Date</th>
					<th>Display Name</th>
					<th>Sys Mod Count</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${sysid}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${r.sys_class_name}</td>
						<td>${r.sys_id}</td>
						<td>${r.delivery_date}</td>
						<td>${r.purchase_date}</td>
						<td>${r.display_name}</td>
						<td>${r.sys_mod_count}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p style="text-align: center">${noofrecordssaved} record(s) saved
			successfully.</p>
	<div>
		<a href="/testjsp" class="button-link" style="margin-top: 20px;">OK</a>
	</div>
	</div>



	<!-- <div class="button-container">
		<button class="beige-btn" type="submit" value="submit" name="saveit">OK</button>
	</div> -->
</body>
</html>