<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <script>
    //Javascript validation
        function validateForm() {
            var username = document.forms["registerForm"]["username"].value;
            var password = document.forms["registerForm"]["password"].value;
            var email = document.forms["registerForm"]["email"].value;
            if (username == "" || password == "" || email == "") {
                alert("All fields are required!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Register</h2> <!--Same as the database schema-->
    <form name="registerForm" action="RegistrationServlet" method="post" onsubmit="return validateForm()">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
