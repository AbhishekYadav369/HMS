<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOSPITAL MANAGEMENT SYSTEM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-slate-50">
<header>
    <div class="text-slate-50 leading-5 md:leading-5 bg-emerald-700 md:bg-emerald-800 capitalize md:uppercase md:font-semibold text-sm md:text-base h-10 min-h-8 md:min-h-full grid justify-items-center md:justify-items-center ">
        <p class="py-1.5 md:py-1.5 ">Welcome to hospital Management System</p>
    </div>
    <div class="text-fuchsia-800 leading-5 md:leading-5 bg-slate-100 md:bg-slate-200 md:capitalize md:text- py-1.5 md:py-1.5 px-5 md:px-10 text-sm md:text-base font-normal md:font-semibold h-10 min-h-10 md:min-h-full flex-col " >
        <span class="px-1.5 md:1.5 w-32 h-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
            <a href="loginHealthCare.jsp">Health Care</a></span>
        <span class="px-1.5 md:1.5 w-32 h-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
            <a href="patientHome.jsp">Patients</a></span>
        <span class="px-1.5 md:1.5 w-32 h-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
            <a href="medicalLogin.jsp">Medical</a></span>
        <span class="px-1.5 md:1.5 w-32 h-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
            <a href="adminLogin.jsp">Admin</a></span>
    </div>
</header>
<main class="bg-slate-50">
     <span class="flex justify-center bg-cover h-140 w-screen mt-3">
         <img id="preview" src="${pageContext.request.contextPath}/images/hms.png" alt="Image Preview">
   </span>
</main>

<%--<footer class="min-h-30 bg-gray-500">--%>

<%--</footer>--%>

</body>
</html>