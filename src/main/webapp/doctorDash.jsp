<%@ page import="com.java.core.beans.HealthCare" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="ISO-8859-1"%>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
    // Check if the user is logged in (i.e., the session attribute "username" exists)
    String userId = (String) session.getAttribute("userId");
    String UserRole = (String) session.getAttribute("userRole");
    if (userId == null && UserRole == null) {
        // If username is null, user is not logged in
        response.sendRedirect("medicalLogin.jsp");  // Redirect to login page
        return;  // Exit to prevent further execution of the JSP
    }
%>
<html>
<head>
    <title>Doctor</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-slate-50">
<header>
    <div class="flex justify-between items-center p-3 min-h-10 md:h-12 bg-emerald-800 md:font-semibold text-white">
        <p class="font-serif capitalize md:uppercase text-lg shadow-md">
            welcome back <%= userId %>!</p>
        <span class="capitalize md:uppercase items-end hover:underline transition-all duration-500 ease-in-out">
        <a href="${pageContext.request.contextPath}/logOut">Log Out</a></span>
    </div>

    <div class="text-fuchsia-800 leading-5 md:leading-5 bg-slate-100 md:bg-slate-200 md:capitalize md:text- py-1.5 md:py-1.5 px-5 md:px-10 text-sm md:text-base font-normal md:font-semibold min-h-10 md:h-12 flex flex-row space-x-4">
        <!-- Profile Form -->
        <span class="px-1.5 md:1.5 w-16 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form  action="${pageContext.request.contextPath}/read-servlet">
                <input type="hidden" name="callBy" value="Profile"/>
                <input type="hidden" name="callByJsp" value="doctorDashJsp"/>
                <input type="submit" value="Profile"/>
            </form></span>

        <!-- Patients Details Form -->
        <span class="px-1.5 md:1.5 w-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form  action="${pageContext.request.contextPath}/read-servlet">
                <input type="hidden" name="callBy" value="PatientsDetails"/>
                <input type="hidden" name="callByJsp" value="doctorDashJsp"/>
                <input type="submit" value="Patients Details"/>
            </form></span>

        <!-- Prescription Form -->
        <span class="px-1.5 md:1.5 w-24 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form  action="${pageContext.request.contextPath}/read-servlet">
                <input type="hidden" name="callBy" value="Prescription"/>
                <input type="hidden" name="callByJsp" value="doctorDashJsp"/>
                <input type="submit" value="Prescription"/>
            </form></span>

        <!-- Search Form -->
        <span class="px-1.5 md:1.5 w-16 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form  action="${pageContext.request.contextPath}/read-servlet">
                <input type="hidden" name="callBy" value="Search"/>
                <input type="hidden" name="callByJsp" value="doctorDashJsp"/>
                <input type="submit" value="Search"/>
            </form></span>
    </div>
</header>

<main class="min-h-130 bg-slate-50">
    <%
        // Get the list from the session
        List<HealthCare> healthCareList = (List<HealthCare>) session.getAttribute("healthCareDetails");
        String callBy = (String) session.getAttribute("callBy");
        if (Objects.equals(callBy, "Profile") && healthCareList != null && !healthCareList.isEmpty()) {
    %>
    <div id="TableContainer" class="relative bg-white p-4 rounded-lg shadow-md">
        <button onclick="closeTable()" class="absolute top-2 right-2 bg-red-500 text-white px-3 py-1 rounded-md">
            X
        </button>

        <div class="overflow-x-auto">
            <table class="min-w-full border-collapse border border-gray-300 bg-white shadow-md">
                <thead class="bg-emerald-800 text-white">
                <tr><th class="border border-gray-300 px-4 py-2">First Name</th>
                    <th class="border border-gray-300 px-4 py-2">Middle Name</th>
                    <th class="border border-gray-300 px-4 py-2">Last Name</th>
                    <th class="border border-gray-300 px-4 py-2">Contacts</th>
                    <th class="border border-gray-300 px-4 py-2">Salary</th>
                    <th class="border border-gray-300 px-4 py-2">Role</th>
                </tr></thead>
                <tbody>
                <%
                    for (HealthCare medicine : healthCareList) {
                %>
                <tr class="hover:bg-gray-100">
                    <td class="border border-gray-300 px-4 py-2"><%= medicine.getFirstName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= medicine.getMiddleName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= medicine.getLastName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= medicine.getNumber() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= medicine.getSalary() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= medicine.getRole() %></td>
                </tr>
                <%
                    }
                %>
                </tbody></table>
        </div>

            <%
    } else {
    %>
        <p class="text-red-600 text-center font-semibold mt-5">No Medicine Records Found</p>
            <%
        }
    %>



</main>

<script>
    function closeTable() { document.getElementById("TableContainer").style.display = "none";}
</script>

<footer class="min-h-30 bg-gray-500">

</footer>
</body>
</html>
