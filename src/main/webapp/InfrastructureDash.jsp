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
        response.sendRedirect("adminLogin.jsp");  // Redirect to login page
        return;  // Exit to prevent further execution of the JSP
    }
%>
<html>
<head>
    <title>Infrastructure</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<header >
    <div class="flex justify-between items-center p-3 min-h-10 md:h-12 bg-emerald-800 md:font-semibold text-white">
        <p class="font-serif capitalize md:uppercase text-lg shadow-md">
            welcome back <%= userId %> for viewing infrastructure details!</p>
        <span class="text-slate-50 md:justify-items-end px-2 hover:bg-red-500 rounded-md transition-all duration-500 ease-in-out">
       <a href="adminDash.jsp">Back</a>
        </span>
    </div>

    <!-- Use flex and wrap the divs in a row (use flex-wrap to handle responsiveness on smaller screens) -->
    <div class="flex justify-start space-x-4 text-fuchsia-800 leading-5 md:leading-5 bg-slate-100 md:bg-slate-200 md:capitalize md:text- py-1.5 md:py-1.5 px-5 md:px-10 text-sm md:text-base font-normal md:font-semibold min-h-10 md:h-12">

        <!-- OPD Form -->
        <span class="px-1.5  w-16 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form action="${pageContext.request.contextPath}/read-servlet">
                 <input type="hidden" name="callBy" value="opd"/>
                <input type="hidden" name="callByJsp" value="InfrastructureDashJsp"/>
                <input type="submit" value="OPD"/>
            </form></span>

        <!-- Patient Area Form -->
        <span class="px-1.5 w-24 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form action="${pageContext.request.contextPath}/read-servlet">
                 <input type="hidden" name="callBy" value="PatientArea"/>
                <input type="hidden" name="callByJsp" value="InfrastructureDashJsp"/>
                <input type="submit" value="Patient Area"/>
            </form></span>

        <!-- Medical Area Form -->
        <span class="px-1.5  w-24  hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form action="${pageContext.request.contextPath}/read-servlet">
                 <input type="hidden" name="callBy" value="medicalArea"/>
                <input type="hidden" name="callByJsp" value="InfrastructureDashJsp"/>
                <input type="submit" value="Medical Area"/>
            </form></span>
    </div>
</header>

<main class="min-h-130 bg-slate-50">

</main>
<footer class="min-h-30 bg-gray-500">

</footer>

</body>
</html>
