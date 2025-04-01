package com.java.servlet.authentication;

import com.java.core.modeldata.HmsDao;
import com.java.core.modeldata.HmsDoaHealthCare;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

//this servlet is used for checking healthCare login and responsible for authorization
//create a session for holding all the details

@WebServlet(name="doctor-check",value="/doctor-check")
public class LoginHealthCare extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId= req.getParameter("userId");
        String password=req.getParameter("password");
        String loginInfo="loginHealthCare";
        String role=req.getParameter("role");
        HmsDao hmsdao=new HmsDoaHealthCare();
        boolean check=hmsdao.doCheck(userId,password,role);

        switch (role) {
            case "Doctor":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("role", role);
                    req.getRequestDispatcher("doctorDash.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("errorMessage", "Invalid username or password or role!");
                    req.getRequestDispatcher("loginHealthCare.jsp").forward(req, resp);
                 }
                break;
            case "Nurse":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("role", role);
                    req.getRequestDispatcher("nurseDash.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("errorMessage", "Invalid username or password or role!");
                    req.getRequestDispatcher("loginHealthCare.jsp").forward(req, resp);
                 }
                break;
            case "WardBoy":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("role", role);
                    req.getRequestDispatcher("wardBoyDash.jsp").forward(req, resp);
                } else {
                    req.setAttribute("errorMessage", "Invalid username or password or role!");
                     req.getRequestDispatcher("loginHealthCare.jsp").forward(req, resp);
                }
                break;
            case "MedicalInCharge":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("role",loginInfo);
                    req.getRequestDispatcher("medicalDash.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("errorMessage", "Invalid username or password!");
                     req.getRequestDispatcher("medicalLogin.jsp").forward(req, resp);
                }
                break;

            default:
                System.out.println("Something went wrong in login health care");
                break;
        }

    }
}
