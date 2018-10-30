<%-- 
    Document   : login
    Created on : Oct 26, 2018, 1:40:17 PM
    Author     : Illestar
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="../resources/style_main.css">
    </head>
    <body>
        <div id="top">
            <h1 style="text-align: center"> Smart Wallet GUI </h1>
            <a href="index.jsp"><img src="../resources/img/logo.png" height="140" width="180" alt="Home Page"/></a>
        </div>
        
        <div id="sidebar">
            <nav>
                <a href="bank.jsp">Funding from the bank</a>
                <a href="receive.jsp">Receive</a>
                <a href="send.jsp">Send</a>
            </nav>
        </div>
        
        <div id="container">
            <div class="content">
                <h1>Login</h1>
                <hr><br>
                <p> Please input your username and password : <br><br>

                <%
                    String message = "";
                    int i = 0;
                    if (request.getParameter("n") != null)
                        i = Integer.parseInt(request.getParameter("n"));

                    if(i == 1) {
                        message = "<p style=\"color:red\">Invalid ID.<br><br>";
                    } else if(i == 2) {
                        message = "<p style=\"color:red\">Invalid Password.<br><br>";
                    } else if(i == 3) {
                        message = "<p style=\"color:red\">Do NOT attempt to inject URL.<br><br>";
                    }
                %>
                <%= message %>

                <form action="login_validate.jsp">
                    <% if (request.getParameter("ph") == null) { %>
                    UserName : <input type="text" name="name" required><br>
                    <% } else { %>
                    Password : <input type="password" name="password" required><br>
                    <% } %>
                    <br>
                    <input type="submit" class="button button_w"> &nbsp; <input type="reset" class="button button_w">
                </form>
            </div>
        </div>
    </body>
</html>