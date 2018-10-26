<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Wallet GUI</title>
        <style type="text/css">
            body {
                background: white;
            }
            
            #top {
                background: yellow;
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
                position: relative;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
            #sidebar a {
                display: inline-block;
                height: 20px;
                width: 300px;
                padding: 30px 0;
                color: white;
                font: bold;
                text-decoration: none;
            }
            
            #sidebar a:hover {
                background: gainsboro;
                cursor: pointer;
            }
            
            #container {
                position: fixed;
                right: 0;
                bottom: 0;
                height: 100%;
                width: 90%;
                background: blanchedalmond;
            }
  
        </style>
    </head>

    <body>
        <div id="top">
            <img src="<c:url value="/resources/img/logo.png" />" />
            <h1> Smart Wallet </h1>
        </div>
        <div id="sidebar">
            <nav>
                <a href="bank.jsp">Funding from the bank</a>
                <a href="receive.jsp">Receive</a>
                <a href="send.jsp">Send</a>
            </nav>
        </div>
        
        <div id="container">
            
            <a>Create a new wallet </a> 
            <!-- respond web page from Each Servlet --> 
            
            <!--
            <form action="/Backend">
                <input type="text" name="EMD"/> <br>
                <input type="submit" />         <br>
            </form>
            -->
        </div>
        
    </body>
</html>
