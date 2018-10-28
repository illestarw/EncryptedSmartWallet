<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page errorPage="_errorDisplay.jsp"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Wallet GUI</title>
        <style type="text/css">
            body {
                background: white;
            }
            
            #top {
                background: gold;
                font-family: Candara, Verdana, Arial;
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: auto;
                z-index: 2;
            }
            
            
            #sidebar {
                background: black;
                position: fixed;
                left: 0;
                height: 100%;
                width: 300px;
                color: white;
                display: inline-block;
                vertical-align: top;
                z-index: 1;
            }
            
            #sidebar nav {
                text-align: center;
                font: 20px Verdana, Arial;
                position: relative;
                top: 30%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
            #sidebar a {
                display: inline-block;
                height: 20px;
                width: 300px;
                padding: 30px 0;
                color: white;
                text-decoration: none;
            }
            
            #sidebar a:hover {
                background: gainsboro;
                cursor: pointer;
                color: black;
            }
            
            #container {
                position: fixed;
                right: 0;
                bottom: 0;
                height: 100%;
                width: 90%;
                background: blanchedalmond;
            }
            
            #container .content {
                font: 20px Constantia, Arial;
                margin-top: 300px;
                margin-left: 500px;
            }
            
            .button {
                font-size: 16px;
                border-radius: 15px;
                color: white;
                padding: 16px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                margin: 4px 2px;
                -webkit-transition-duration: 0.3s;
                transition-duration: 0.3s;
                cursor: pointer;
            }
            
            .button_w {
                background-color: white; 
                color: black; 
                border: 2px solid #008CBA;
            }

            .button_w:hover {
                background-color: #008CBA;
                color: white;
            }
        </style>
    </head>

    <body>
        <div id="top">
            <h1 style="text-align: center"> Smart Wallet GUI </h1>
            <a href="index.jsp"><img src="<c:url value="/resources/img/logo.png" />" height="140" width="180" style="position: fixed; left:40; top:10"/></a>
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
                <a href="register.jsp"><button class="button button_w">Create a new wallet</button></a>
                <a href="login.jsp"><button class="button button_w">Log in to a wallet</button></a>
            </div>
        </div>
        
    </body>
</html>
