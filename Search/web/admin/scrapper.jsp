<%@page import="java.util.ArrayList"%>
<%@page import="models.varwere"%>
<%@include file="header.jsp" %>
<%
varwere v=new varwere(); 
ArrayList websites=v.getWebsites();
%>
			<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Home</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-edit"></i>
					<a href="#">Website Scrapper</a>
				</li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon edit"></i><span class="break"></span>Scrap for website Content</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
						</div>
					</div>
					<div class="box-content">
                                             <center id="cog"><img src="img/cog.gif" height="120" width="120" ><br>
                                            Working, please wait.
                                            </center>
						<form class="form-horizontal">
						  <fieldset>
							
							<div class="control-group">
							  <label class="control-label" for="date01">Select A Website Here</label>
							  <div class="controls">
                                                              <select id="web" class="form-control">
                                                                  <%
                                                                  int c=websites.size();
                                                                  for(int x=0;x < c;x++){
                                                                      ArrayList website=(ArrayList)websites.get(x);
                                                                  %>
                                                                  <option value="<% out.print(website.get(0)); %>"><% out.print(website.get(1)); %></option>
                                                                  
                                                                  <%
                                                                  }
                                                                  %>
                                                              </select>	
                                                          </div>
							</div>

							    
							
							<div class="form-actions">
                                                            <input type="button" id="scrap" class="btn btn-primary" value="Start Scrapping">
							 
							</div>
						  </fieldset>
						</form>   

					</div>
				</div><!--/span-->

			</div><!--/row-->

			
    

	</div><!--/.fluid-container-->
	
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
	
	<%@include file="footer.jsp"%>