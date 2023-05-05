<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Create Records</title>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		body {
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
			background-color: #f2f2f2;
		}
		
		.container {
			max-width: 500px;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			box-shadow: 0 0 10px rgba(0,0,0,0.2);
			border-radius: 5px;
			text-align: center;
		}

		input[type="number"] {
			padding: 10px;
			border-radius: 5px;
			border: none;
			box-shadow: 0 0 5px rgba(0,0,0,0.2);
			width: 100%;
			margin: 10px 0;
			font-size: 16px;
		}

		input[type="submit"] {
			padding: 10px 20px;
			background-color: #4CAF50;
			color: #fff;
			border: none;
			border-radius: 5px;
			font-size: 16px;
			cursor: pointer;
		}

		input[type="submit"]:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Create Records</h1>
		<form onsubmit="createRecords(event)">
			<label for="num-records">How many records do you want to create?</label>
			<input type="number" id="num-records" name="num-records" min="1" max="1000" required>
			<input type="submit" value="Create">
		</form>
	</div>

	<script>
		function createRecords(event) {
			event.preventDefault();
			const numRecords = document.getElementById("num-records").value;
			alert(`Creating ${numRecords} records...`);
			// Here you would perform the actual record creation using the entered number
		}
	</script>
</body>
</html>
