<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String email=request.getParameter("email");
String password=request.getParameter("password");
varwere varw=new varwere();
ArrayList r=varw.loginDoc(email,password);
ArrayList system= varw.getSystem();
if(r.size() > 1){
    session.setAttribute("name",r.get(0));
        session.setAttribute("email",r.get(1));
            session.setAttribute("file_path",system.get(1));
            session.setAttribute("system_name",system.get(0));
           session.setAttribute("id",r.get(2));
               response.setStatus(200);
response.sendRedirect("index.jsp");
}else{
  //out.println(r.get(0));  
  response.setStatus(200);
response.sendRedirect("login.jsp?login=0");
}
%>