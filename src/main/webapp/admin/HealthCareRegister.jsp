<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 16-02-2025
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HealthCareRegister</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-slate-50">
<header class="flex justify-between items-center p-2.5 min-h-8 md:h-10 bg-emerald-600 md:font-semibold  text-slate-100 min-w-40">
    <p class="text-capatialize md:uppercase ">Register HealthCare </p>
    <a class="text-capatialize md:uppercase items-end hover:underline  transition-all duration-500 ease-in-out " >Log Out</a>
</header>
<main class="flex items-center justify-center min-h-screen  bg-slate-100">
    <div class="w-100 min-h-40 md:w-130 bg-gray-100 rounded-lg shadow-md ">
        <form method="post" action="">
            <div class="text-capatialize md:uppercase text-lg flex flex-col space-y-6 p-4">
                <label>First_Name:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="text" value="First Name"/></label>
                <label>Middle_Name:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-48" type="text" value="Middle Name"/> </label>
                <label>Last_Name:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="text" value="Last Name"/></label>
                <label>Role:<input class="mx-4 rounded-md p-1 bg-slate-50 min-w-58" type="text" value="Role"/></label>
                <label>Number:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="number" value="Phone Number"/></label>
                <label>Salary:<input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="number" value="Salary"/></label>
                <input class = "text-emerald-900 md:justify-items-end text-semibold hover:bg-emerald-300 p-3 rounded-md  transition-all duration-500 ease-in-out "   type="submit" value="Register here"/>
            </div>
        </form>
    </div>
</main>

</body>
</html>
