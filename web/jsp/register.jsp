<%-- 
    Document   : register
    Created on : Oct 26, 2018, 2:36:56 PM
    Author     : Illestar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
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
            .button
            {
                padding: 10px 20px;
                text-align: center;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                -webkit-transition-duration: 0.4s; /* Safari */
                transition-duration: 0.4s;
                cursor: pointer;
   
                background-color: #ffffcf;
                color: #fd7179;
                border: 2px solid #fd7179;
                border-radius: 15px;
            }
            .button:hover
            {
                background-color: #fd7179;
                color: #ffffcf;
            }
        </style>
    </head>
    <body>
        <div id="content">
            <h1>Register a new wallet</h1>
            <hr><br>
            <p> Please input your username and password : <br><br>
            
            <form action="register_validate.jsp">
                <% if (request.getParameter("ph") == null) { %>
                UserName : <input type="text" name="name"><br>
                <% } else { %>
                Password : <input type="password" name="password"><br>
                <% } %>
                <br>
                <input type="submit" class="button"> &nbsp; <input type="reset" class="button">
            </form>
        </div>
    </body>
</html>