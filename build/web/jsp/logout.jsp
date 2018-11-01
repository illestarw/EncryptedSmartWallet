<%@page import="servlet.LoginCredential"%>

<jsp:useBean class="servlet.Counter" id="loginTry" scope="session" />
<jsp:useBean class="java.lang.StringBuilder" id="userName" scope="session" />

<%
    if (userName != null)
        userName.setLength(0);  

    loginTry.setC(0);
    
    if (request.getParameter("sc") != null)
        response.sendRedirect(request.getParameter("sc") + ".jsp");
    else
        response.sendRedirect("index.jsp");

%>