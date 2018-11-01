<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- construct if time allowed --%>
<%@page errorPage="_errorDisplay.jsp"%>

<jsp:useBean class="java.lang.StringBuilder" id="userName" scope="session" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Wallet GUI</title>
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
                <% if (userName.length() == 0) {%>
                    Please Login to continue..
                <% } else { %>
                    Welcome back, user <%= userName %>.
                <% } %>
                
                <br><br>
                
                <a href="register.jsp"><button class="button button_orange">Create a new wallet</button></a>
                <% if (userName.length() == 0) {%>
                    <a href="login.jsp"><button class="button button_orange">Log in to a wallet</button></a>
                    <a><button class="button button_orange button_disable">Log out</button></a>
                <% } else { %>
                    <a><button class="button button_orange button_disable">Log in to a wallet</button></a>
                    <a href="logout.jsp"><button class="button button_orange">Log out</button></a>
                <% } %>
            </div>
        </div>
        
    </body>
</html>
