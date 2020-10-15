<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String email=request.getParameter("email");
String password=request.getParameter("password");
String name=request.getParameter("name");
String id=request.getParameter("id");
varwere varw=new varwere();
String r=varw.clientupdate(id,name,email,password);
response.setStatus(200);
response.sendRedirect("clients.jsp?r="+r);
%>