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
    // Check if the user is logged in (i.e., the session attribute "username" exists)
    String userId = (String) session.getAttribute("userId");
    String UserRole = (String) session.getAttribute("userRole");
    if (userId == null && UserRole ==null ) {
        // If username is null, user is not logged in
        response.sendRedirect("login.jsp");  // Redirect to login page
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
<header class="flex justify-between items-center p-2.5 min-h-8 md:h-10 bg-emerald-600 md:font-semibold  text-slate-100 min-w-40">
    <p class="font-serif capitalize md:uppercase  text-lg shadow-md">
        welcome back <%= userId %>!</p>
    <span class="capitalize md:uppercase items-end hover:underline  transition-all duration-500 ease-in-out " >
        <a href="${pageContext.request.contextPath}/logOut">Log Out</a></span>
</header>

<main  class="flex items-center justify-center min-h-screen  bg-slate-100">
    <div class="w-90 min-h-40 md:w-120 h-60 bg-gray-100 rounded-lg shadow-md
   capitalize md:uppercase  text-lg flex items-center flex-col space-y-6 p-4">
        <span class="hover:underline  transition-all duration-500 ease-in-out " >
            <a href="">Infrastructure_Details</a></span>
        <span class="hover:underline  transition-all duration-500 ease-in-out " >
            <a href="HealthCareRegister.jsp">Register_HealthCare</a></span>
        <span class="hover:underline  transition-all duration-500 ease-in-out " >
            <a href="patientRegister.jsp">Register_Patients</a></span>

    </div>
</main>
</body>
</html>
