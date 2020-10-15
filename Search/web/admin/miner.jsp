<%@page import="models.Mining"%>
<%@page import="models.MyFilteredClassifier"%>
<%
Mining mining=new Mining();
String file=session.getAttribute("file_path")+"classifier.arff";
mining.trainData(file);
out.println("Data classification completed");
%>