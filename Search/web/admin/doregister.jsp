<%@page import="java.io.PrintWriter"%>
<%@page import="models.user" %>
<%@page import="models.varwere" %>
<% 
String email=request.getParameter("email");
String password=request.getParameter("password");
String location="Harare";//request.getParameter("location");
String name=request.getParameter("name");
varwere varw=new varwere();
String r=varw.registerDoc(name,email,password,location);
if(r.equals("true")){
    session.setAttribute("name",name);
        session.setAttribute("email",email);
            session.setAttribute("location",location);
                session.setAttribute("password",password);
                response.setStatus(200);
response.sendRedirect("index.jsp");
}else{
  out.println(r);  
}
%>