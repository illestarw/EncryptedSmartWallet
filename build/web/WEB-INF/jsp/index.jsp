<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Wallet UI</title>
        <style type="text/css">
            body {
                background: bisque;
                text-align: center;
            }
        </style>
    </head>

    <body>
        <div>
            <form action="/Backend">
                <input type="text" name="EM"/>  <br>
                <input type="text" name=""/>    <br>
                <input type="submit" />         <br>
            </form>
        </div>
        
        <br><hr><br>
        
        <p><i>To display a different welcome page for this project, modify</i>
            <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
    </body>
</html>
