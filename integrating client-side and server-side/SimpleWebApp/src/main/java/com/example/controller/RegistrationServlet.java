package com.example.controller;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-KRSQ446S;databaseName=UserDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true;")) {
            String sql = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.executeUpdate();
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Username already exists.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
    }
}
