<%@page import="servlet.LoginCredential"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>

<%!
    Map<String, LoginCredential> map = new TreeMap<String, LoginCredential>();
%>

<%-- define an object to be the counter (Can't use wrapper class like int because not able to modify content)--%>
<jsp:useBean class="servlet.Counter" id="loginTry" scope="session" />
<jsp:useBean class="java.lang.StringBuilder" id="userName" scope="session" />

<%
    String filePath = application.getRealPath("/resources/data/users");
    Path path = Paths.get(filePath);
    List<String> data = Files.readAllLines(path);


    for (String d : data)
    {
        String[] s = d.split(",");
        LoginCredential lc = new LoginCredential(s);
        map.put(lc.getId(), lc);
    }

    
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String dest;
    
    
    // tune from login to register (check if username existed)
    if (userName.length() == 0)
    {
        if (name == null)
        {
            dest = "login.jsp?n=3";
        }
        else
        {
            LoginCredential tar = map.get(name);
            if (tar != null)
            {
                userName.append(name);
                dest = "login.jsp?ph=1&n=0";
            }
            else
            {
                dest = "login.jsp?n=1";
                loginTry.setC(loginTry.getC() + 1);
            }

            if (loginTry.getC() == 3) // Alert when getting the credential wrong thrice
            {
                dest = "error.html";
                loginTry.setC(0);
            }
        }
    }
    else
    {
        name = userName.toString();
        LoginCredential tar = map.get(name);
        if (tar.getPw().equals(password))
        {
            dest = "welcome.html";
            userName.setLength(0);
            loginTry.setC(0);
        }
        else
        {
            dest = "login.jsp?ph=1&n=2";
            loginTry.setC(loginTry.getC() + 1);
        }
        
        if (loginTry.getC() == 3) // Alert when getting the credential wrong thrice
        {
            dest = "login_failtry.jsp";
            userName.setLength(0);
            loginTry.setC(0);
        }
    }
    

    
%>
<jsp:forward page="<%= dest %>" />
           
