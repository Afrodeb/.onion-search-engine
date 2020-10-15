<%@page import="models.Mining"%>
<%@page import="models.MyFilteredClassifier"%>
<%
Mining mining=new Mining();
String file=session.getAttribute("file_path")+"classifier.arff";
String trainedData=mining.createClassifierTrainingModel();
mining.writeFile(file,trainedData);
out.print("Model created successfully");
%>