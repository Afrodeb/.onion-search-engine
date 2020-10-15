<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String web=request.getParameter("web");
varwere varw=new varwere();
String r=varw.addWebsite(web);
response.setStatus(200);
response.sendRedirect("websites.jsp?r="+r);
%>