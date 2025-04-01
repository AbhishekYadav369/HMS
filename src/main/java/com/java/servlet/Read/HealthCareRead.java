package com.java.servlet.Read;

import com.java.core.beans.HealthCare;
import com.java.core.beans.Medical;
import com.java.core.modeldata.HmsDaoRead;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/healthCare-read")
public class HealthCareRead extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String callByJSP=(String) session.getAttribute("callByJSP");
        String callBy = request.getParameter("callBy");
        String userName=(String) session.getAttribute("userId");
        String userRole = (String) session.getAttribute("role");
        HmsDaoRead hmsDao = new HmsDaoRead();
        String resend=null;
        switch (callByJSP) {
            case "wardBoyJSP":
                 resend="wardBoyDash.jsp";
                nurseWard(request, response,session ,resend);
                break;
            case "doctorDashJsp":
                String callByDoctor =request.getParameter("callBy");
                switch (callByDoctor) {
                    case "Profile":
                        session.setAttribute("callBy","Profile");
                        List<HealthCare> healthCares= hmsDao.healthCareRead(userName,userRole);
                        session.setAttribute("callBy", "Profile");
                        session.setAttribute("healthCareDetails",healthCares);
                        request.getRequestDispatcher("doctorDash.jsp").forward(request, response);
                        break;
                    case "PatientsDetails":
                        session.setAttribute("callBy","PatientsDetails");
                        request.getRequestDispatcher("doctorDash.jsp").forward(request, response);
                        break;
                    case "Prescription":
                        session.setAttribute("callBy","Prescription");
                        request.getRequestDispatcher("doctorDash.jsp").forward(request, response);
                        break;
                    case "Search":
                        session.setAttribute("callBy","Search");
                        request.getRequestDispatcher("doctorDash.jsp").forward(request, response);
                        break;
                    default:
                        System.out.println("Invalid call by doctor in healthCare-read servlet");
                        break;
                }
                break;
            case "nurseDashJsp":
                resend="nurseDash.jsp";
                nurseWard(request, response, session,resend);
                break;
            default:
                System.out.println("Invalid call by JSP in healthCare-read servlet");
                break;
        }
    }

    private void nurseWard(HttpServletRequest request, HttpServletResponse response, HttpSession session,String resend) throws ServletException, IOException {
        String callBy=(String) session.getAttribute("callBy");
        switch (callBy) {
               case "BookAppointment":
                   session.setAttribute("callBy","BookAppointment");
                   request.getRequestDispatcher(resend).forward(request, response);
                   break;
               case "Search":
                   session.setAttribute("callBy","Search");
                   request.getRequestDispatcher(resend).forward(request, response);
                   break;
               case "Access":
                   session.setAttribute("callBy","Access");
                   request.getRequestDispatcher(resend).forward(request, response);
                   break;
               case "Profile":
                   session.setAttribute(resend,"Profile");
                   request.getRequestDispatcher("nurseDash.jsp").forward(request, response);
                   break;
               default:
                   System.out.println("Invalid call by nurse or ward in healthCare-read servlet");
                   break;
       }
    }
}
