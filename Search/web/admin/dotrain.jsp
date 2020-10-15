<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String set=request.getParameter("set");
String name=request.getParameter("name");
varwere varw=new varwere();
String r=varw.training(name,set);
response.setStatus(200);
response.sendRedirect("training.jsp?r="+r);
%>