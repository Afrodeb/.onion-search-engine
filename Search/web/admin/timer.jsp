<%@page import="java.io.PrintWriter"%>
<%
response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();

		for (int i = 0; i < 20; i++) {

			writer.write("data: "+ System.currentTimeMillis() +"\n\n");
			writer.flush();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		writer.close();
%>