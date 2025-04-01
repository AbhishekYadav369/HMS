<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 19-02-2025
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-slate-50">
<header class="flex justify-between items-center p-2.5 min-h-10 md:h-12 bg-emerald-600 md:font-semibold  text-slate-100 min-w-40">
    <p class="capitalize md:uppercase ">Welcome to Health Care</p>
    <span class="capitalize md:uppercase items-end hover:bg-red-400 p-1  rounded-md  transition-all duration-500 ease-in-out  " >
        <a  href="index.jsp">Back</a></span>
</header>
<main class="flex items-center justify-center min-h-screen  bg-slate-100">
    <div class="w-100 min-h-40 md:w-130 bg-gray-100 rounded-lg shadow-md ">
        <form method="post" action="${pageContext.request.contextPath}/doctor-check">
            <div class="text-capitalize md:uppercase text-lg flex flex-col space-y-6 p-4">
                <label> USER ID :<input class="mx-2 rounded-md p-1 bg-slate-50 min-w-58" type="text" name="userId" placeholder="User Name or email id"/></label>
                <label>PASSWORD :<input class="mx-2 rounded-md p-1 bg-slate-50 min-w-52" type="password" name="password" placeholder="password"></label>
                <label>ROLE :<select class="text-sm md:text-lg mx-3 rounded-md p-1 bg-slate-50 min-w-58" name="role">
                    <option>Select</option>
                    <option value="Doctor">Doctor</option>
                    <option value="Nurse">Nurse</option>
                    <option value="WardBoy">WardBoy</option>
                </select></label>
                <p class=" text-red-800 text-sm font-serif">
                    <%= request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage") %>
                </p>
                <input class = "text-emerald-900 md:justify-items-end text-semibold hover:bg-emerald-400 p-3 rounded-md  transition-all duration-500 ease-in-out " type="submit" value=" Login here"/>
            </div>
        </form>
    </div>
</main>
</body>
</html>
