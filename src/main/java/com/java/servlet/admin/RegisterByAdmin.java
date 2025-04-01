package com.java.servlet.admin;

import com.java.core.modeldata.HmsDao;
import com.java.core.modeldata.HmsDoaHealthCare;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registerByAdmin")
public class RegisterByAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String register = request.getParameter("register");
        String fName = request.getParameter("fName");
        String mName = request.getParameter("mName");
        String lName = request.getParameter("lName");
        String phoneNo = request.getParameter("phoneNo");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        System.out.println("register by admin called");
        switch (register) {
            case "healthCareRegister":
                System.out.println("healthCareRegister called");
                String role = request.getParameter("role");
                String salary = request.getParameter("salary");
                HmsDoaHealthCare hmsDao = new HmsDoaHealthCare();

                if (hmsDao.insert(fName, mName, lName, role, phoneNo, salary,userName,password) == 1){
                    request.setAttribute("successMessage", "Health Care Registered Successfully!");
                    request.getRequestDispatcher("HealthCareRegisterByAdmin.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Each fields must be filled ");
                    request.getRequestDispatcher("HealthCareRegisterByAdmin.jsp").forward(request, response);
                }

                break;
            case "patientRegister":
                System.out.println("patientRegister called");
                //patients Details
                String medicalHistory = request.getParameter("medicalHistory");
                //guardian details
                String gFirstName = request.getParameter("gFirstName");
                String gLastName = request.getParameter("gLastName");
                HmsDao hmsDao1=new HmsDao();
                if(hmsDao1.insert(fName,mName,lName,gFirstName,gLastName,phoneNo,medicalHistory,userName,password)==1){
                    request.setAttribute("successMessage", "added successfully!");
                    request.getRequestDispatcher("patientRegisterByAdmin.jsp").forward(request, response);
                }else {
                    request.setAttribute("errorMessage", "Each fields must be filled ");
                     request.getRequestDispatcher("patientRegisterByAdmin.jsp").forward(request, response);
                }
                break;
            default:
                System.out.println("invalid attempt  by "+register+" for registering into database!");

                break;
        }


    }
}
