<%-- 
    Document   : send
    Created on : Oct 23, 2018, 6:57:56 PM
    Author     : Illestar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlet.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean class="java.lang.StringBuilder" id="userName" scope="session" />

<jsp:useBean class="servlet.Account" id="account" scope="session" />

<%
    if (userName.length() == 0) response.sendRedirect("login.jsp?n=4");
    account.setId(userName.toString());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transferring: Send money</title>
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
                <a href="handshake.jsp">Sync : Give</a>
                <a href="handshake2.jsp">Sync : Receive</a>
            </nav>
        </div>
        
        <div id="container">
            <div class="content">
                <h1>Transferring : Send Money</h1>
                <hr><br>
                <p class='user'> User ${userName}, Wallet ID ${account.WID} &nbsp; (Not you? <a href='logout.jsp?sc=login'>Login with another wallet.</a>) <br>
                <p class='user'> Account balance : ${account.balance} <br><br>
                <p> Please fill out the form to complete transactions : <br><br>

                <form action="/EncryptedSmartWallet/send" method="post">
                    Amount ($) : <input type="text" name="amount" required>
                    <br><br>
                    Wallet ID of receiver: <input type="text" name="WIDrcv" required> &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; 
                    <input type="submit" value="Confirm sending" class="button button_orange"> &nbsp;  &nbsp; 
                    <input type="reset" value="Clear the form" class="button button_orange">
                </form>
                
            </div>
        </div>
    </body>
</html>