<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 19-02-2025
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients Home page!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<header>
    <div class="text-slate-50 leading-5 md:leading-5 bg-emerald-700 md:bg-emerald-800 capitalize md:uppercase md:font-semibold text-sm md:text-base h-10 md:min-w-full grid justify-items-center md:justify-items-center ">
        <p class="py-1.5 md:py-1.5 ">Welcome To Patients Home Page</p>
    </div>
    <div class="text-fuchsia-800 leading-5 h-10 md:leading-5 bg-slate-100 md:bg-slate-200 md:capitalize md:text- py-1.5 md:py-1.5 px-5 md:px-10 text-sm md:text-base font-normal md:font-semibold md:min-w-full flex-col " >
        <span class="px-1.5 md:1.5 w-32 h-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
            <a href="patientLogin.jsp">login here</a></span>
        <span class="px-1.5 md:1.5 w-32 h-32 hover:bg-emerald-300 rounded-md p-0.5 transition-all duration-500 ease-in-out ">
            <a href="patientSignUp.jsp">Register Yourself</a></span>
        <span class="text-red-800 mx-3 ml-auto absolute right-0 hover:bg-red-300 rounded-md p-0.5 px-1 transition-all duration-500 ease-in-out ">
            <a href="index.jsp">Back</a></span>
    </div>
</header>
<main class=" bg-slate-50">
    <span class="flex justify-center bg-cover h-140 w-screen mt-3">
         <img id="preview" src="${pageContext.request.contextPath}/images/pat.png" alt="Image Preview">
   </span>
</main>
<%--<footer class="min-h-30 bg-gray-600 text-white">--%>
<%--    <p>Patients Feedback</p>--%>
<%--</footer>--%>

</body>
</html>
