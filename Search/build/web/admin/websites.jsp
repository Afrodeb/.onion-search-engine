<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>
<%@page import="models.*" %>
			
			<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">Websites</a></li>
			</ul>

			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						
                                                <br>
                                                <%
                                                if(request.getParameter("r") != null){
                                                 out.print(request.getParameter("r"));
                                                }else{
                                                 out.print("<h2><i class='halflings-icon user'></i><span class='break'></span>Websites</h2>");
                                                }
                                                %>
						<div class="box-icon">
                                                    <a href="newwebsite.jsp" class="btn btn-primary"><i class="halflings-icon wrench"></i>New Website</a>
							<a href="#" class="btn-setting"><i class="halflings-icon wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>Website Url</th>
								  <th>Added</th>
								  
								  <th>Actions</th>
							  </tr>
						  </thead>   
						  <tbody>
                                                      <%
                                                      varwere v= new varwere();
                                                      ArrayList websites=v.getWebsites();
                                                      ArrayList website=new ArrayList<String>();
                                                      out.print(website.toString());
                                                      int c=websites.size();
                                                      //for ((ArrayList)website: websites){}
                                                      for (int x=0;x<c;x++){
                                                          website=(ArrayList)websites.get(x);
                                                          String update="webupdate.jsp?id="+website.get(0);
                                                          String delete="deletewebsite.jsp?id="+website.get(0);
                                                          String scrapped="scrapped.jsp?id="+website.get(0);
                                                      %>
							<tr>
                                                            <td><% out.print(website.get(1)); %></td>
							    <td class="center"><% out.print(website.get(2)); %></td>
								
								
								<td class="center">
									
                                                                    <a class="btn btn-info" href="<% out.print(update); %>">
										Update 
									</a>
                                                                        <a class="btn btn-info" href="<% out.print(scrapped); %>">
										Content  
									</a>
									<a class="btn btn-danger" href="<% out.print(delete); %>">
										Delete 
									</a>
								</td>
							</tr>
							
						<% } %>	
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->

	
    

	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	
	<div class="clearfix"></div>
<%@include file="footer.jsp" %>
