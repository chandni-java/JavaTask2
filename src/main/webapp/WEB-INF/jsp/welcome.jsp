<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
        html, body {
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 16px;
            height: 100vh;
            background-color: #f0f7f4;
            margin: 0;
            padding: 0;
        }
        
        form {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.1);
            width: 400px;
            padding: 24px;
            text-align: center;
        }
        
        input[type="number"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
            outline: none;
        }
        
        button {
            background-color: #23a388;
            color: #ffffff;
            padding: 12px 24px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        
        button:hover {
            background-color: #1a7c6d;
        }
        
        h1 {
            font-size: 24px;
            color: #23a388;
            margin-bottom: 24px;
        }
        
        hr {
            border: none;
            border-top: 1px solid #ccc;
            margin: 16px 0;
        }
    </style>
<meta charset="ISO-8859-1">
<title>Snow Integration</title>
</head>
<body>
    <form action="/result" method="post">
        <h1>Welcome to Snow Integration Utility</h1>
        <div>
            <hr>
            <label><strong>How many records do you want to migrate?</strong></label>
            <br><br>
            <input type="number" placeholder="Number of Records" name="records" required>
        </div>
        <br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>