<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String question=request.getParameter("question");
varwere varw=new varwere();
String r=varw.addQuestion(question);
response.sendRedirect("allquestions.jsp");
%>