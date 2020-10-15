<%@page import="com.jaunt.JauntException"%>
<%@page import="com.jaunt.UserAgent"%>
<%
try{
  UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
  //userAgent.setProxyHost("3.14.159.68");        //specify the proxy host (ip address)
  
  userAgent.visit("http://3g2upl4pq6kufc4m.onion/");  //visit a url
  userAgent.setProxyPort(8118); 
  out.print(userAgent.doc.innerHTML());               //print the document as HTML
}
catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
  out.print(e);
}
%>