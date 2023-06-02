<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snow Results</title>
<style>
.hidden-input {
	display: none;
}

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
	text-decoration: none;
}

.beige-btn:hover {
	background-color: #D2B48C; /* Lighter beige on hover */
}

.center-image {
	display: flex;
	justify-content: center;
	text-align: center;
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

.my-input {
	width: 235px; /* Adjust the width value as per your requirements */
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
	function funcSelectAll() {
		if (document.forms[0].selectAllCheck.checked == true) {
			for (var a = 0; a < document.forms[0].checkboxid.length; a++) {
				document.forms[0].checkboxid[a].checked = true;
			}
		} else {
			for (var a = 0; a < document.forms[0].checkboxid.length; a++) {
				document.forms[0].checkboxid[a].checked = false;
			}
		}
	}

	function validateForm() {
		var checkboxes = document.querySelectorAll('input[type="checkbox"]');
		var isChecked = false;

		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				isChecked = true;
				break;
			}
		}

		if (!isChecked) {
			/* alert("Please select at least one record."); */
			return false; // Prevent form submission
		}

		return true; // Allow form submission
	}

	function showLoader() {
		document.getElementById('loader').style.display = 'block';
		window.addEventListener('unload', hideLoader);
	}

	function hideLoader() {
		document.getElementById('loader').style.display = 'none';
	}

	function onSubmitForm(event) {
		// Call the first JavaScript function
		var returnValue = validateForm();
		if (returnValue == false) {
			alert("Please select at least one record.");
			return false;
		}

		hideLoader();
		// Call the second JavaScript function
		showLoader();

		return returnValue;
	}
</script>
</head>
<body>
	<!-- modelAttribute="result" -->
	<!-- modelAttribute="snr" -->
	<form action="/savedata" method="post"
		onsubmit="return onSubmitForm(event);">
		<div class="form-group" id="snowrecords">
			<h1 align="center">Servicenow Results</h1>
			<table>
				<thead>
					<tr>
						<th>Select All<input type=checkbox name='selectAllCheck'
							onClick='funcSelectAll()'></th>
						<th>Sr No.</th>
						<th>Sys Class Name</th>
						<th>System Id</th>
						<th>Delivery Date</th>
						<th>Purchase Date</th>
						<th>Display Name</th>
						<th>Sys Mod Count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${snr.result}" varStatus="status">
						<tr>
							<td><input type="checkbox" style="border: 0px"
								id="checkboxid" name="result[${status.index}].isSelected"
								value="1" /></td>
							<td>${status.index + 1}</td>
							<td><input style="border: 0px"
								name="result[${status.index}].sys_class_name"
								value="${r.sys_class_name}" /></td>
							<td><input class="my-input" style="border: 0px"
								name="result[${status.index}].sys_id" value="${r.sys_id}"
								 /></td>
							<td><input style="border: 0px"
								name="result[${status.index}].delivery_date"
								value="${r.delivery_date}" readonly /></td>
							<td><input style="border: 0px"
								name="result[${status.index}].purchase_date"
								value="${r.purchase_date}" /></td>
							<td><input style="border: 0px"
								name="result[${status.index}].display_name"
								value="${r.display_name}" /></td>
							<td><input style="border: 0px; width:50px"
								name="result[${status.index}].sys_mod_count"
								value="${r.sys_mod_count}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="center-image" id="loader" style="display: none;">
				<img src="/images/spinner.gif" alt="Loading...">
			</div>
			<div class="button-container">
				<button class="beige-btn" type="submit" value="submit">Submit</button>
				<a href="/testjsp" class="beige-btn" style="margin-top: 20px;">Back</a>
			</div>
		</div>
	</form>
</body>
</html>
