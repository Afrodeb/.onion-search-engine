<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.*" %>
<%@page import="com.jaunt.*;" %>
<%
    varwere v = new varwere();
    String web=request.getParameter("web");
    //String web="24";
    //v.deleteScrappedByWeb(web);
    String done=v.crawl(web);
    out.print(done);
%>