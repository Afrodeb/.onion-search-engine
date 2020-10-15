<%@page import="java.util.ArrayList"%>
<%@page import="models.varwere"%>
<%@include file="header.jsp" %>
<%
varwere varw=new varwere();
ArrayList clients,techs,websites,minedSites,client=new ArrayList();
clients=varw.clients();
techs=varw.admins();
minedSites=varw.getMinedContent();
websites=varw.getWebsites();
int num=clients.size();
int doc=techs.size();
int web=websites.size();
int mined=minedSites.size();
%>

			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">Dashboard</a></li>
			</ul>

			<div class="row-fluid">
				
				
				
				
                                        <div class="span6 statbox green" onTablet="span6" onDesktop="span3">
					
					<div class="number"><% out.println(web); %>
                                            </div>
					<div class="title">Websites</div>
									</div>
                                            
                                            <div class="span6 statbox blue" onTablet="span6" onDesktop="span3">
					
					<div class="number"><% out.println(mined); %>
                                            </div>
					<div class="title">Crawled pages</div>
									</div>
					
				
			</div>		

       
			
		
				
			
	
			
	
			
       

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
        <%@include file="footer.jsp" %>