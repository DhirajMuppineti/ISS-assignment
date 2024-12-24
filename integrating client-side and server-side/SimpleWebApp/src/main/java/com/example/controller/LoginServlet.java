package com.example.controller;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Load the JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:sqlserver://LAPTOP-KRSQ446S;databaseName=UserDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true;")) {

                // Query to validate username and password
                String sql = "SELECT * FROM Users WHERE username = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    if (password.equals(rs.getString("password"))) {
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        response.sendRedirect("welcome.jsp");
                    } else {
                        request.setAttribute("errorMessage", "Invalid password.");
                    }
                } else {
                    request.setAttribute("errorMessage", "User not found.");
                }

                // Forward to login page with error message
                if (request.getAttribute("errorMessage") != null) {
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "JDBC Driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
        }
    }
}
