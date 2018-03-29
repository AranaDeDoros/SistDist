<%-- 
    Document   : newjsp
    Created on : 28-mar-2018, 1:51:25
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	soa.NewWebService_Service service = new soa.NewWebService_Service();
	soa.NewWebService port = service.getNewWebServicePort();
	 // TODO initialize WS operation arguments here
	int a = 0;
	int b = 0;
	// TODO process result here
	int result = port.add(a, b);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
