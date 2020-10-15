<%@page import="models.varwere"%>
<%@page import="java.util.ArrayList"%>
<html>
<title>
<%
String search=request.getParameter("search");
varwere v=new varwere();
if(search != null){
    ArrayList results=v.search(search);
    
%>
<% out.print(search); %>
</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<link href="search.css" rel="stylesheet" />
</head>
<body>
<div class="row">
<form class="form-inline form-wrapper" action="dosearch.jsp" method="post">
  <div class="form-group">
     <input type="text" class="form-control" value="<% out.print(search); %>" name="search" id="search" placeholder="Search for..." required>
  </div>
  <button type="submit" class="btn btn-primary">Search</button>
  <label for="duration">Duration: <?php echo $duration; ?></label>
</form>
</div>
<div class="row">
<%
int c=results.size();
if(c > 0){
for(int x=0; x< c; x++){
    
/*result.add(rs.getString("page"));
result.add(rs.getString("page_name"));
result.add(rs.getString("description"));
result.add(rs.getString("id"));*/
    ArrayList result=(ArrayList)results.get(x);
    String title="No Title";
    String description="No Description";
    String url="http://localhost:8080/ethel";
    description=result.get(0).toString();
    url=result.get(1).toString();
    if(!description.equals("")){
%>
<div class="result">
    <a href="<% out.println(url); %>"><% out.println(url); %></a>
<p>
<%
 out.print(description.substring(0,400)); 
%>
</p>
</div>
<%	
    }
}
}else{
    out.print("<div class='result'><a href='index.jsp'>Empty results returned</a></div>");   
}
%>	
</div>
</body>
</html>
<%
}else{
response.setStatus(200);
response.sendRedirect("index.jsp?r=Please+specify+search+query");
}
%>