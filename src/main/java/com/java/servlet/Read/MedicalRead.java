package com.java.servlet.Read;

import com.java.core.beans.Medical;
import com.java.core.modeldata.HmsDao;
import com.java.core.modeldata.HmsDaoRead;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/medical-read")
public class MedicalRead extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(false);
    if (session.getAttribute("callByJSP") != null) {
        String callBy = request.getParameter("callBy");
        HmsDaoRead hmsDao = new HmsDaoRead();
        switch (callBy) {
            case "GenerateBill":
//                hmsDao.read("purchase",patientId);
                session.setAttribute("callBy", "GenerateBill");
                request.getRequestDispatcher("medicalDash.jsp").forward(request, response);
                break;
            case "Search":
//                hmsDao.read("");
                session.setAttribute("callBy", "Search");
                request.getRequestDispatcher("medicalDash.jsp").forward(request, response);
                break;
            case "Medicine":
                List<Medical> medicine= hmsDao.medicineRead("medical");
                session.setAttribute("callBy", "Medicine");
                session.setAttribute("medicineList", medicine);
                request.getRequestDispatcher("medicalDash.jsp").forward(request, response);
                break;
            default:
                System.out.println("Invalid callBy in medical read Servlet");
                break;
        }

    }
    else{ System.out.println("invalid attempt to access medical read servlet"); ;}
    }
}
