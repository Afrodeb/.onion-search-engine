<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.varwere" %>
<%
response.setContentType("text/event-stream");
response.setCharacterEncoding("UTF-8");  
    PrintWriter writer = response.getWriter();
    String id=(String)session.getAttribute("pid");
    varwere varw=new varwere();
                ArrayList noti=new ArrayList();
                 if(session.getAttribute("pid") != null){                      
                       noti=varw.getMessages(id.trim());
                       //noti=varw.getMessages("1");
                 }
                       
     			writer.write("data: "+ noti.toString() +"\n\n");
			writer.flush();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		writer.close();
%>