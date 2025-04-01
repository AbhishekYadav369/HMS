package com.java.servlet.Read;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/read-servlet")
public class ReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String DashCall=request.getParameter("callByJsp");
        HttpSession session=request.getSession(false);
        switch (DashCall){
            case "doctorDashJsp":

                session.setAttribute("callByJSP","doctorDashJsp");
                request.getRequestDispatcher("/healthCare-read").forward(request, response);
                break;
            case "nurseDashJsp":
                session.setAttribute("callByJSP","nurseDashJsp");
                request.getRequestDispatcher("/healthCare-read").forward(request, response);
                break;
            case "wardBoyJSP":
                session.setAttribute("callByJSP","wardBoyJSP");
                request.getRequestDispatcher("/healthCare-read").forward(request, response);
                break;

            case "medicalDashJsp":
                System.out.println("read servlet called");
                session.setAttribute("callByJSP","medicalDashJsp");
                request.getRequestDispatcher("/medical-read").forward(request, response);
                break;

            case "patientDashJsp":
                session.setAttribute("callByJSP","patientDashJsp");
                request.getRequestDispatcher("/patients-read").forward(request, response);
                break;

            case "InfrastructureDashJsp":
                session.setAttribute("callByJSP","InfrastructureDashJsp");
                request.getRequestDispatcher("/infrastructure-read").forward(request, response);
                break;
            default:
                System.out.println("Invalid attempt to access Read Servlet!");
                break;

        }

    }
}
