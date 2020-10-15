<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String email=request.getParameter("email");
String password=request.getParameter("password");
String name=request.getParameter("name");
varwere varw=new varwere();
String r=varw.register(name,email,password);
response.setStatus(200);
response.sendRedirect("clients.jsp?r="+r);
%>