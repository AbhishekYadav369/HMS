<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 19-02-2025
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Your Self</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<header class="flex items-center justify-between min h-8 md:h-10 bg-emerald-600 md:font-semibold  px-4
py-1 md:py-1.5 text-slate-100 min-w-40">
    <p class="capitalize md:uppercase ">Welcome To Sign Up Page ! </p>
    <span class=" text-white capitalize md:uppercase  md:justify-items-end px-2 hover:bg-red-500 rounded-md  transition-all duration-500 ease-in-out ">
        <a href="patientHome.jsp">Back</a></span>
</header>

<main class="flex items-center justify-center min-h-screen my-3 bg-slate-100">
    <div class="w-100 md:w-130 bg-gray-100 rounded-lg shadow-md">

        <form method="post" action="${pageContext.request.contextPath}/registerByPatient">
            <div class="flex flex-col space-y-2 p-3">
                <p class=" text-lg md:text-xl">Patients Details:</p>
                <label class="capitalize md:uppercase ">First_Name :
                    <input class="mx-3 rounded-md p-1 bg-slate-50 min-w-54" type="text" name="fName" placeholder="First Name"/></label>
                <label class="capitalize md:uppercase ">Middle_Name :
                    <input class="mx-0.5.5 rounded-md p-1 bg-slate-50 min-w-52" type="text" name="mName" placeholder="Middle Name"/> </label>
                <label class="capitalize md:uppercase ">Last_Name :
                    <input class="mx-3 rounded-md p-1 bg-slate-50 min-w-54" type="text" name="lName" placeholder="Last Name"/></label>
                <label class="capitalize md:uppercase ">Medical_History :
                    <input class="mx-1 rounded-md p-1 min-h-16 bg-slate-50 min-w-48" type="text" name="medicalHistory" placeholder="Medical History"/></label>

                <hr class="my-2 border-t-2 border-gray-100">

                <p class=" text-lg md:text-xl">Guardian Details:</p>
                <label class="capitalize md:uppercase ">First_Name :
                    <input class="mx-3 rounded-md p-1 bg-slate-50 min-w-54" type="text" name="gFirstName" placeholder="First Name"/></label>
                <label class="capitalize md:uppercase ">Last_Name :
                    <input class="mx-3 rounded-md p-1 bg-slate-50 min-w-54" type="text" name="gLastName" placeholder="Last Name"/></label>
                <label class="capitalize md:uppercase ">Number :
                    <input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="number" name="phoneNo" placeholder="Phone Number"/></label>
                <label class="capitalize md:uppercase ">User_Id :
                    <input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="text" name="userId" placeholder="User Id"/></label>
                <label class="capitalize md:uppercase ">Password :
                    <input class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="password" name="password" placeholder="password"/></label>

                <p class=" text-red-800 text-sm font-serif">
                    <%= request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage") %>
                </p>
                <input  class = " md:justify-items-end m-3 text-semibold hover:bg-emerald-300 p-4 rounded-md  transition-all duration-500 ease-in-out " type="submit" value="Register here"/>
                <p class=" text-emerald-800 text-sm font-serif">
                    <%= request.getAttribute("successMessage") == null ? "" : request.getAttribute("successMessage") %>
                </p>
            </div>
        </form>
    </div>
</main>
<footer>  </footer>
</body>
</html>
