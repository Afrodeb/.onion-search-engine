<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String question=request.getParameter("answer");
String qid=request.getParameter("id");
varwere varw=new varwere();
String r=varw.addAnswer(question,qid);
response.sendRedirect("qview.jsp?id="+qid);
%>