<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"> 
<title>Snow Results</title>
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
<script type="text/javascript">
	function checkUncheck(main) {
		all = document.getElementsByName('selectedItems');
		for (var a = 0; a < all.length; a++) {
			all[a].checked = main.checked;
		}
	}
</script>
</head>
<body>
	<form action ="/savedata" method="post" modelAttribute="ServiceNowResource">
		<div class="container">
			<h1 align="center">Snow Results</h1>
			<table>
				<thead>
					<tr>
						<th>Select All<input type=checkbox
							onclick='checkUncheck(this)'></th>
						<!-- <th>Sr No.</th> -->
						<th>Sys Class Name</th>
						<th>Display Name</th>
						<th>Invoice Number</th>
						<th>Delivery Date</th>
						<th>Retirement Date</th>
						<th>Purchase Date</th>
						<th>Depreciation Date</th>
						<th>Serial Number</th>
						<th>Sys Mod Count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${result}" varStatus="status">
						<tr>
							<td>
							  <input type="checkbox" name="selectedItems"
								value="${r}">  
								<!-- ${r.sys_class_name} -->
								</td>
							<%-- <td>${status.index + 1}</td> --%>
							<td>${r.sys_class_name}</td>
							<td>${r.display_name}</td>
							<td>${r.invoice_number}</td>
							<td>${r.delivery_date}</td>
							<td>${r.retirement_date}</td>
							<td>${r.purchase_date}</td>
							<td>${r.depreciation_date}</td>
							<td>${r.serial_number}</td>
							<td>${r.sys_mod_count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="button-container">
				<button class="beige-btn" type="submit" name="saveit">Submit</button>
			</div>
		</div>
	</form>
</body>
</html>
