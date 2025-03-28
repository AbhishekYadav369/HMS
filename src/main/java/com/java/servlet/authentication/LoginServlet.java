package com.java.servlet.authentication;
import com.java.core.modeldata.HmsDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

//this is servlet which is used for user login and do all the authentication
// job by creating session
//this is used for checking admin,medical and patients login
@WebServlet(name="check-servlet",value="/check-servlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

       String userId= req.getParameter("userId");
        String password=req.getParameter("password");
       String loginInfo=req.getParameter("loginInfo");
        HmsDao hmsdao=new HmsDao();
        boolean check=hmsdao.doCheck(loginInfo,userId,password);

        switch (loginInfo) {
            case "admin_login":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("userRole",loginInfo);
                    resp.sendRedirect("admin/admin_login.jsp");
                } else {
                    req.setAttribute("errorMessage", "Invalid username or password!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("admin/login.jsp");
                    dispatcher.forward(req, resp);
                }
                break;
            case "patients_login":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("userRole",loginInfo);
                    resp.sendRedirect("patients/patientDash.jsp");
                } else {
                    req.setAttribute("errorMessage", "Invalid username or password!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("patients/loginPatient.jsp");
                    dispatcher.forward(req, resp);
                }
                break;
            case "medical_login":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("userRole",loginInfo);
                    resp.sendRedirect("medical/medicalDash.jsp");
                } else {
                    req.setAttribute("errorMessage", "Invalid username or password!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("medical/medicalLogin.jsp");
                    dispatcher.forward(req, resp);
                }
                break;
            default:
                req.setAttribute("errorMessage", "Invalid Request Code!");
        }


    }
}
