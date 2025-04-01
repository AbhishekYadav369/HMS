<%--
  Created by IntelliJ IDEA.
  User: Abhishek Yadav
  Date: 16-02-2025
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login first here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body  class="bg-slate-50">
<header class="flex items-center justify-between min h-8 md:h-10 bg-emerald-600 md:font-semibold  px-4
py-1 md:py-1.5 text-slate-100 min-w-40">
    <h3 class="capitalize md:uppercase ">Welcome To Admin Login Page!!</h3>
    <span class=" text-slate-50 md:justify-items-end px-2 hover:bg-red-500 rounded-md  transition-all duration-500 ease-in-out ">
        <a href="index.jsp">Back</a></span>

</header>

<main class="flex items-center justify-center min-h-screen  bg-slate-100">
    <div  class="w-90 min-h-40 md:w-120 bg-gray-100 rounded-lg shadow-md">
        <form method="POST" action="${pageContext.request.contextPath}/check-servlet">
            <div class=" capitalize md:uppercase text-lg flex flex-col space-y-6 p-4">
                <label> User_Id :<input  class="mx-3 rounded-md p-1 bg-slate-50 min-w-58" type="text" name="userId" placeholder="User Name "/></label>
                <label>PASSWORD :<input  class="mx-1 rounded-md p-1 bg-slate-50 min-w-50" type="password" name="password" placeholder="password"></label>
                <input type="hidden" name="loginInfo" value="admin_login">
                <input  class = "text-emerald-900 md:justify-items-end text-semibold hover:bg-emerald-300 p-3 rounded-md  transition-all duration-500 ease-in-out "  type="submit" value=" Login here"/>
                <%-- Display error message if it exists --%>
                <p class=" text-red-800 text-sm font-serif">
                    <%= request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage") %>
                </p>
            </div>
        </form>
    </div>
</main>

</body>
</html>
