<%@page import="servlet.LoginCredential"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.IOException"%>

<%!
    Map<String, LoginCredential> map = new TreeMap<String, LoginCredential>();
%>

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
    String entry, dest;

    LoginCredential tar = map.get(name);
    if (tar != null)
        dest = "register.jsp?n=0"; // duplicate username
    else
    {
        dest = "register.jsp?n=1"; // success
        entry = name + "," + password;
        // byte b[] = entry.getBytes(); // convert string to byte array
        
        try
        {
            FileWriter fw = new FileWriter(filePath, true); // true for append new entry
            fw.write(entry + "\n");
            fw.close();
        }
        catch(IOException e)
        {
            System.err.println("Failed : IOException during registering" + e.getMessage());
            dest = "register.jsp?n=2"; // IOException (prompt for retry)
        }
    }
%>
<jsp:forward page="<%= dest %>" />
           
