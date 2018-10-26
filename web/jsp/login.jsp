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