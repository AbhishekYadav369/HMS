<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 16-02-2025
  Time: 14:47
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
    String UserRole = (String) session.getAttribute("userRole");
    if (userId == null && UserRole ==null ) {
        // If username is null, user is not logged in
        response.sendRedirect("adminLogin.jsp");  // Redirect to login page
        return;  // Exit to prevent further execution of the JSP
    }
%>

<html>
<head>
    <title>Administration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-slate-50">
<header >
    <div class="flex justify-between items-center p-3  min-h-10 md:h-12 bg-emerald-800 md:font-semibold  text-white">
        <p class="font-serif capitalize md:uppercase  text-lg shadow-md">
            welcome back <%= userId %>!</p>
        <span class="capitalize md:uppercase items-end hover:underline  transition-all duration-500 ease-in-out " >
        <a href="${pageContext.request.contextPath}/logOut">Log Out</a></span>
    </div>
    <div class="text-fuchsia-800  leading-5 md:leading-5 bg-slate-100 md:bg-slate-200 md:capitalize md:text- py-1.5 md:py-1.5 px-5 md:px-10 text-sm md:text-base font-normal md:font-semibold min-h-10 md:h-12 flex-col " >
        <span class="px-1.5 md:1.5 w-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
           <a href="InfrastructureDash.jsp">Infrastructure Details</a></span>
        <span class=" px-1.5 md:1.5 w-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
           <a href="HealthCareRegisterByAdmin.jsp">Register HealthCare</a></span>
        <span class="px-1.5 md:1.5 w-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
            <a href="patientRegisterByAdmin.jsp">Register Patients</a></span>

    </div>
</header>

<main class="min-h-130 bg-slate-50">

</main>
<footer class="min-h-30 bg-gray-500">

</footer>

</body>
</html>
