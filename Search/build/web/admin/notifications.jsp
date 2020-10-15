<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.varwere" %>
<%
response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
                varwere varw=new varwere();
                ArrayList noti=new ArrayList();
                ArrayList before=new ArrayList();
                
                if(session.getAttribute("id") != null){
                    noti=varw.getNotifications((String)session.getAttribute("id"));
                }
                int size=noti.size();
		PrintWriter writer = response.getWriter();

		//for (int i = 0; i < size; i++) {

			writer.write("data: "+ noti.toString() +"\n\n");
			writer.flush();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
		writer.close();
%>
