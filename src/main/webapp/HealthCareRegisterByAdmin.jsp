<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 16-02-2025
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="ISO-8859-1"%>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
    // Check if the user is logged in (i.e., the session attribute "username" exists)
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
        // If username is null, user is not logged in
        response.sendRedirect("adminDash.jsp");  // Redirect to login page
        return;  // Exit to prevent further execution of the JSP
    }
%>

<html>
<head>
    <title>HealthCareRegister</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-slate-50">
<header class="flex justify-between items-center p-2.5 min-h-8 md:h-10 bg-emerald-600 md:font-semibold  text-slate-100 min-w-40">
    <p class="font-serif capitalize md:uppercase  text-lg  shadow-md">
        welcome back <%=userId%> for registering health care!</p>
    <span class="text-white capitalize md:uppercase  md:justify-items-end px-2 hover:bg-red-500 rounded-md  transition-all duration-500 ease-in-out " >
        <a href="adminDash.jsp" >Back</a></span>
</header>
<main class="flex flex-col items-center  justify-center min-h-screen">
    <div class=" bg-slate-100">
        <div class="w-100 min-h-40 md:w-130 bg-gray-100 rounded-lg shadow-md ">
            <form method="post" action="${pageContext.request.contextPath}/registerByAdmin">
                <div class="capitalize md:uppercase text-lg flex flex-col space-y-6 p-4">
                    <label>First_Name:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="text" name="fName" placeholder="First Name"/></label>
                    <label>Middle_Name:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-48" type="text" name="mName" placeholder="Middle Name"/> </label>
                    <label>Last_Name:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="text" name="lName" placeholder="Last Name"/></label>
                    <label>Role :<select class="text-sm md:text-lg mx-3 rounded-md p-1 bg-slate-50 min-w-58" name="role">
                        <option>Select</option>
                        <option value="Doctor">Doctor</option>
                        <option value="Nurse">Nurse</option>
                        <option value="WardBoy">WardBoy</option>
                        <option value="MedicalInCharge">MedicalInCharge</option>
                    </select></label>
                    <label>Number:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="number" name="phoneNo" placeholder="Phone Number"/></label>
                    <label>Salary:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="number" name="salary" placeholder="Salary"/></label>
                    <label>UserName:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="text" name="userName" placeholder="UserName"/></label>
                    <label>Password:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="password" name="password" placeholder="password"/></label>

                    <input type="hidden" name="register" value="healthCareRegister">
                    <%-- Display  message if it exists --%>
                    <p class=" text-red-800 text-sm font-serif">
                        <%= request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage") %>
                    </p>
                    <p class="text-emerald-900 text-sm font-serif">
                        <%= request.getAttribute("successMessage") == null ? "" : request.getAttribute("successMessage") %>
                    </p>
                    <input class = "text-emerald-900 md:justify-items-end text-semibold hover:bg-emerald-300 p-3 rounded-md
                 transition-all duration-500 ease-in-out "   type="submit" value="Register here"/>
                </div>
            </form>
        </div>

    </div>
</main>
</body>
</html>
