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
public class LoginServlet extends HttpServlet {
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
                    req.getRequestDispatcher("adminDash.jsp").forward(req, resp);

                } else {
                    req.setAttribute("errorMessage", "Invalid username or password!");
                     req.getRequestDispatcher("adminLogin.jsp").forward(req, resp);
                }
                break;
            case "patients":
                if (check) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("userRole",loginInfo);
                    req.getRequestDispatcher("patientDash.jsp").forward(req, resp);
                }
                else {
                    req.setAttribute("errorMessage", "Invalid username or password!");
                     req.getRequestDispatcher("patientLogin.jsp").forward(req, resp);
                  }
                break;

            default:
                System.out.println("something went wrong in Login Servlet");
                break;
        }


    }
}
