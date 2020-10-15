<%@page import="opennlp.tools.util.Span"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<%@page import="models.Processor" %>
<% 
ArrayList conversation=new ArrayList();
Processor processor= new Processor();
varwere varw=new varwere();
String message="Dr Fortue:"+request.getParameter("message");
String id="system";
String to=request.getParameter("id");
to=to.trim();
if(!message.equals("")){
out.print(message+"--"+id+"=="+to);
varw.sendMessage(id,to,message);
response.sendRedirect("chat.jsp?id="+to);
}else{
    out.print("Message haiko");
}
%>