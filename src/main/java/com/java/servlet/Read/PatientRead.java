package com.java.servlet.Read;

import com.java.core.beans.Medical;
import com.java.core.beans.Patients;
import com.java.core.modeldata.HmsDaoRead;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/patients-read")
public class PatientRead extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession(false);
if (session.getAttribute("callByJSP") != null) {
    String callBy= request.getParameter("callBy");
    String username =(String) session.getAttribute("userId");
    HmsDaoRead hmsDao = new HmsDaoRead();
    switch (callBy) {
        case "Profile":
            List<Patients> PatientProfile= hmsDao.patientRead(username);
            session.setAttribute("profile", PatientProfile);
            session.setAttribute("callBy", "Profile");
            request.getRequestDispatcher("patientDash.jsp").forward(request, response);
            break;
        case "BookAppointment":
            session.setAttribute("callBy", "BookAppointment");
            request.getRequestDispatcher("patientDash.jsp").forward(request, response);
            break;
        case "HealthCare":
            session.setAttribute("callBy", "HealthCare");
            request.getRequestDispatcher("patientDash.jsp").forward(request, response);
            break;
        default:
            System.out.println("Invalid callBy in patient read servlet");
            break;
    }
    }
else{ System.out.println("invalid callByJSP for patient read servlet");}

    }
}
