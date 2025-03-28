package com.java.servlet;

import com.java.core.HmsDao;
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
        }else System.out.println("Register Fail");

    }
}
