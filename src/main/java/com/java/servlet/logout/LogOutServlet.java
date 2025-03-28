package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current session and invalidate it
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  // Invalidate the session, removing all attributes
        }
        // Redirect to the login page
        response.sendRedirect("index.jsp");
    }
}
