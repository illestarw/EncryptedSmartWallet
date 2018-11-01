<%-- 
    Document   : register
    Created on : Oct 26, 2018, 2:36:56 PM
    Author     : Illestar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean class="java.lang.StringBuilder" id="userName" scope="session" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
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
                <h1>Register a new wallet</h1>
                <hr><br>
                <p> Register with your username and password : <br><br>

                <%
                    String message = "";
                    int i = -1;
                    if (request.getParameter("n") != null)
                        i = Integer.parseInt(request.getParameter("n"));

                    if(i == 0) {
                        message = "<p style=\"color:red\">Username existed, please try another one.<br><br>";
                    } else if(i == 1) {
                        message = "<p style=\"color:black\">Account created. Please return to the home page and log in.<br><br>";
                    } else if(i == 2) {
                        message = "<p style=\"color:red\">Exception occured during action. Retry again please.<br><br>";
                    }
                %>
                <%= message %>

                <form action="register_validate.jsp" method="post">
                    Username : <input type="text" name="name" required><br>
                    Password : <input type="password" name="password" required><br>
                    <br>
                    <input type="submit" class="button button_blue"> &nbsp; <input type="reset" class="button button_blue">
                </form>
            </div>
        </div>
    </body>
</html>