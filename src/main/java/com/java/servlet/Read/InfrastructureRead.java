package com.java.servlet.Read;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/infrastructure-read")
public class InfrastructureRead extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("callByJSP") != null) {
            String callBy =req.getParameter("callBy");
            switch (callBy) {
                case "opd":
                    session.setAttribute("callBy", "opd");
                    req.getRequestDispatcher("InfrastructureDash.jsp").forward(req, resp);
                    break;
                case "PatientArea":
                    session.setAttribute("callBy", "PatientArea");
                    req.getRequestDispatcher("InfrastructureDash.jsp").forward(req, resp);
                    break;
                case "medicalArea":
                    session.setAttribute("callBy", "medicalArea");
                    req.getRequestDispatcher("InfrastructureDash.jsp").forward(req, resp);
                    break;
                default:
                    System.out.println("Invalid callBy in InfrastructureRead");
                    break;
            }

        }
        else{
            System.out.println("Invalid attempt to access Infrastructure Read servlet!");
        }

    }
}
