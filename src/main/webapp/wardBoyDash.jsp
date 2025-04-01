<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 19-02-2025
  Time: 12:26
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
        response.sendRedirect("medicalLogin.jsp");  // Redirect to login page
        return;  // Exit to prevent further execution of the JSP
    }
%>
<html>
<head>
    <title>Ward Boy</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<header >
    <div class="flex justify-between items-center p-3  min-h-10 md:h-12 bg-emerald-800 md:font-semibold  text-white">
        <p class="font-serif capitalize md:uppercase  text-lg shadow-md">
            welcome back <%= userId %>!</p>
        <span class="capitalize md:uppercase items-end hover:underline  transition-all duration-500 ease-in-out " >
        <a href="${pageContext.request.contextPath}/logOut">Log Out</a></span>
    </div>

    <div class="text-fuchsia-800 leading-5 md:leading-5 bg-slate-100 md:bg-slate-200 md:capitalize md:text- py-1.5 md:py-1.5 px-5 md:px-10 text-sm md:text-base font-normal md:font-semibold min-h-10 md:h-12 flex flex-row space-x-4">
        <!-- Profile Form -->
        <span class="px-1.5 md:1.5 w-20 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
        <form action="${pageContext.request.contextPath}/read-servlet">
            <input type="hidden" name="callBy" value="Profile"/>
            <input type="hidden" name="callByJsp" value="wardBoyJSP"/>
            <input type="submit" value="Profile"/>
        </form></span>

        <!-- Access Form -->
        <span class="px-1.5 md:1.5 w-20 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
        <form  action="${pageContext.request.contextPath}/read-servlet">
            <input type="hidden" name="callBy" value="Access"/>
            <input type="hidden" name="callByJsp" value="wardBoyJSP"/>
            <input type="submit" value="Access"/>
        </form></span>

        <!-- Search Form -->
        <span class="px-1.5 md:1.5 w-20 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
        <form  action="${pageContext.request.contextPath}/read-servlet">
            <input type="hidden" name="callBy" value="Search"/>
            <input type="hidden" name="callByJsp" value="wardBoyJSP"/>
            <input type="submit" value="Search"/>
        </form></span>

        <!-- Book Appointment Form -->
        <span class="px-1.5 md:1.5 w-38 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
        <form  action="${pageContext.request.contextPath}/read-servlet">
            <input type="hidden" name="callBy" value="BookAppointment"/>
            <input type="hidden" name="callByJsp" value="wardBoyJSP"/>
            <input type="submit" value="Book Appointment"/>
        </form></span>
    </div>

</header>
<main class="min-h-130 bg-slate-50">

</main>
<footer class="min-h-30 bg-gray-500">

</footer>
</body>
</html>
