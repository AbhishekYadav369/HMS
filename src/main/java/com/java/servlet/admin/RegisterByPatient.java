package com.java.servlet.admin;

import com.java.core.modeldata.HmsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name="registerByPatient",value="/registerByPatient")
public class RegisterByPatient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //patients Details
        String fName = request.getParameter("fName");
        String mName = request.getParameter("mName");
        String lName = request.getParameter("lName");
        String medicalHistory = request.getParameter("medicalHistory");
        //guardian details
        String gFirstName = request.getParameter("gFirstName");
        String gLastName = request.getParameter("gLastName");
        String Phone = request.getParameter("phoneNo");
        String userId=request.getParameter("userId");
        String password = request.getParameter("password");
        HmsDao hmsDao1=new HmsDao();
        if(hmsDao1.insert(fName,mName,lName,gFirstName,gLastName,Phone,medicalHistory,userId,password)==1){
            request.setAttribute("successMessage","Patient Registration Successful");
            request.getRequestDispatcher("patientSignUp.jsp").forward(request,response);
        }
        else{
            request.setAttribute("errorMessage","Patients Registration Failed");
            request.getRequestDispatcher("patientSignUp.jsp").forward(request,response);
           }

    }
}
