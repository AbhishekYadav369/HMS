package com.java.servlet;

import com.java.core.HmsDao;
import com.java.core.HmsDoaHealthCare;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="registerByAdmin",value="/registerByAdmin")
public class RegisterByAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String register = request.getParameter("register");
        switch (register) {
            case "healthCareRegister":
                String fName = request.getParameter("fName");
                String mName = request.getParameter("mName");
                String lName = request.getParameter("lName");
                String role = request.getParameter("role");
                String phoneNo = request.getParameter("phoneNo");
                String salary = request.getParameter("salary");
                HmsDoaHealthCare hmsDao = new HmsDoaHealthCare();
                if (hmsDao.insert(fName, mName, lName, role, phoneNo, salary) == 1){
                    System.out.println("Register Success");
                    request.setAttribute("successMessage", "1 row affected!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin/HealthCareRegister.jsp");
                    dispatcher.forward(request, response);
                } else {
                    System.out.println("Register Fail");
                    request.setAttribute("errorMessage", "Each fields must be filled ");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin/HealthCareRegister.jsp");
                    dispatcher.forward(request, response);
                }


                break;
            case "patientRegister":
                //patients Details
                String pFname = request.getParameter("pFname");
                String pMname = request.getParameter("pMname");
                String pLname = request.getParameter("pLname");
                String medicalHistory = request.getParameter("medicalHistory");

                //guardian details
                String gFname = request.getParameter("gFname");
                String gLname = request.getParameter("gLname");
                String Phone = request.getParameter("gPhone");
                HmsDao hmsDao1=new HmsDao();
                if(hmsDao1.insert(pFname,pMname,pLname,gFname,gLname,Phone,medicalHistory)==1){
                    System.out.println("Register Success");
                    request.setAttribute("successMessage", "added successfully!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin/patientRegister.jsp");
                    dispatcher.forward(request, response);
                }else {
                    System.out.println("Register Fail");
                    request.setAttribute("errorMessage", "Each fields must be filled ");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin/patientRegister.jsp");
                    dispatcher.forward(request, response);
                }

                break;
            default:
                System.out.println("invalid register");

                break;
        }


    }
}
