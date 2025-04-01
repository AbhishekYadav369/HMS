<%@ page import="com.java.core.beans.Patients" %>
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
    if (userId == null) {
        // If username is null, user is not logged in
        response.sendRedirect("adminLogin.jsp");  // Redirect to login page
        return;  // Exit to prevent further execution of the JSP
    }
%>
<html>
<head>
    <title>Patients</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<header>
    <div class="flex justify-between items-center p-3 min-h-10 h-12 bg-emerald-800 md:font-semibold text-white">
        <p class="font-serif capitalize md:uppercase text-lg shadow-md">
            welcome back <%= userId %>!</p>
        <span class="capitalize md:uppercase items-end hover:underline transition-all duration-500 ease-in-out">
        <a href="${pageContext.request.contextPath}/logOut">Log Out</a></span>
    </div>

    <div class="text-fuchsia-800 leading-5 md:leading-5 bg-slate-100 md:bg-slate-200 md:capitalize md:text- py-1.5 md:py-1.5 px-5 md:px-10 text-sm md:text-base font-normal md:font-semibold min-h-10 md:h-12 flex flex-row space-x-4">
        <!-- Profile Form -->
        <span class="px-1.5 md:1.5 w-16 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form action="${pageContext.request.contextPath}/read-servlet">
                <input type="hidden" name="callBy" value="Profile"/>
                 <input type="hidden" name="callByJsp" value="patientDashJsp"/>
                <input type="submit" value="Profile"/>
            </form></span>

        <!-- HealthCare Form -->
        <span class="px-1.5 md:1.5 w-24 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form  action="${pageContext.request.contextPath}/read-servlet">
                <input type="hidden" name="callByJsp" value="patientDashJsp"/>
                <input type="hidden" name="callBy" value="HealthCare"/>
                <input type="submit" value="HealthCare"/>
            </form></span>

        <!-- Book Appointment Form -->
        <span class="px-1.5 md:1.5 w-38 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out">
            <form  action="${pageContext.request.contextPath}/read-servlet">
                <input type="hidden" name="callByJsp" value="patientDashJsp"/>
                <input type="hidden" name="callBy" value="BookAppointment"/>
                <input type="submit" value="Book Appointment"/>
            </form></span>

    </div>
</header>
<main class="min-h-130 bg-slate-50 p-5">
    <%
        // Get the list from the session
        List<Patients> profileList = (List<Patients>) session.getAttribute("profile");
        String callBy = (String) session.getAttribute("callBy");

        if (Objects.equals(callBy, "Profile") && profileList != null && !profileList.isEmpty()) {
    %>

    <div id="TableContainer" class="relative bg-white p-4 rounded-lg shadow-md">
        <button onclick="closeTable()" class="absolute top-2 right-2 bg-red-500 text-white px-3 py-1 rounded-md">
             X
        </button>

        <div class="overflow-x-auto mt-5">
            <table class="min-w-full border-collapse border border-gray-300">
                <thead class="bg-emerald-800 text-white">
                <tr>
                    <th class="border border-gray-300 px-4 py-2">Pat.Fir.Name</th>
                    <th class="border border-gray-300 px-4 py-2">Pat.Mid.Name</th>
                    <th class="border border-gray-300 px-4 py-2">Pat.Las.Name</th>
                    <th class="border border-gray-300 px-4 py-2">Gar.Fir.Name</th>
                    <th class="border border-gray-300 px-4 py-2">Gar.Las.Name</th>
                    <th class="border border-gray-300 px-4 py-2">Phone No.</th>
                    <th class="border border-gray-300 px-4 py-2">Medical History</th>
                </tr></thead><tbody>
                <%
                    for (Patients details : profileList) {
                %>
                <tr class="hover:bg-gray-100">
                    <td class="border border-gray-300 px-4 py-2"><%= details.getFirstName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= details.getMiddleName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= details.getLastName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= details.getGarFirstName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= details.getGarLastName() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= details.getNumber() %></td>
                    <td class="border border-gray-300 px-4 py-2"><%= details.getMedicalHistory() %></td>
                </tr>
                <%
                    }
                %>
                </tbody></table>
        </div>
    </div>

    <%
    } else {
    %>
    <p class="text-red-600 text-center font-semibold mt-5">No Profile Records Found</p>
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
