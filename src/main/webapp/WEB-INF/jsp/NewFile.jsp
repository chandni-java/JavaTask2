<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
        body {
            background-color: #ffffff;
            color: #000000;
            text-align: center;
            font-family: Arial, sans-serif;
        }
        
        #container {
            margin-top: 100px;
        }
        
        h1 {
            color: #22aa22;
        }
        
        input[type="number"] {
            padding: 10px;
            font-size: 16px;
            border: 2px solid #22aa22;
            background-color: #f2f2f2;
            color: #000000;
        }
        
        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #22aa22;
            border: none;
            color: #ffffff;
            cursor: pointer;
        }
    </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div id="container">
        <h1>Enter a Number</h1>
        <form action="process.jsp" method="post">
            <input type="number" name="number" placeholder="Enter a number" />
            <br /><br />
            <input type="submit" value="Submit" />
        </form>
    </div>
</body>
</html>