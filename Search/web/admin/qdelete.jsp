<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<%
String q=request.getParameter("id");
varwere varw=new varwere();
String a=varw.deleteQuetion(q);
response.sendRedirect("allquestions.jsp?a="+a);
%>