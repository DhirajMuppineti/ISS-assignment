<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script>
        //Validation for the forms
        function validateForm() {
            var username = document.forms["loginForm"]["username"].value;
            var password = document.forms["loginForm"]["password"].value;
            if (username == "" || password == "") {
                alert("All fields are required!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Login</h2>
    <form name="loginForm" action="LoginServlet" method="post" onsubmit="return validateForm()">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
    <a href="register.jsp">First time? Register here</a>
    <% if (request.getAttribute("errorMessage") != null) { %>
	    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
	<% } %>

</body>
</html>
