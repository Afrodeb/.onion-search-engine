<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String web=request.getParameter("web");
String id=request.getParameter("id");
varwere varw=new varwere();
String r=varw.updateWebsite(web,id);
response.setStatus(200);
response.sendRedirect("websites.jsp?r="+r);
%>