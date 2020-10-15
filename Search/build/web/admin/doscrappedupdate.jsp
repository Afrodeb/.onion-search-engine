<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String content=request.getParameter("content");
String id=request.getParameter("id");
String wid=request.getParameter("wid");
varwere varw=new varwere();
String r=varw.updateScrapped(content,id);
response.setStatus(200);
response.sendRedirect("scrapped.jsp?r="+r+"&id="+wid);
%>