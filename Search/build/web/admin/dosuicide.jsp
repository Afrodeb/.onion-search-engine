<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String question=request.getParameter("word");
String score=request.getParameter("score");
varwere varw=new varwere();
String r=varw.addSuicideWord(question,score);
response.sendRedirect("allsuiciadal.jsp");
%>