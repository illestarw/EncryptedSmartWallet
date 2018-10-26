<%-- 
    Document   : login_failtry
    Created on : Oct 26, 2018, 2:20:47 PM
    Author     : Illestar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Invalid attempts alert</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            body
            {
                font-family: verdana;
                background : #ffeeeb;
            }
            #content
            {
                display: block;
                text-align: center;
                margin: 30px auto;
            }
        </style>
    </head>
    <body>
        <div id="content">
            <h1>Error</h1>
            <hr><br>
            <p style="color: red"> You have failed to log in three times!
                
            <a href="login.jsp"> Try Again</a>
        </div>
    </body>
</html>
