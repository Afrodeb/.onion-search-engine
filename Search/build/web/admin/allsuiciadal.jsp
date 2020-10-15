<%@page import="java.util.ArrayList"%>
<%@page import="models.varwere"%>
<%@include file="header.jsp" %>
<%
ArrayList questions=new ArrayList();
ArrayList question=new ArrayList();
varwere varw=new varwere();
questions=varw.getAllSuicideWords();

%>
			
			
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">All questions</a></li>
			</ul>

			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon question-sign"></i>
                                                    <span class="break"></span>Questions 
                                                <%
                                                if(request.getParameter("a") !=null && !request.getParameter("a").equals("")){
                                                   out.println(request.getParameter("a"));
                                                }
                                                %>
                                                </h2>
						
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>Words</th>
								  <th>Date added</th>
								  <th>Actions</th>
							  </tr>
						  </thead>   
						  <tbody>
     <%
   int size=questions.size();
     String delete,view,update,word,created;
    for(int x=0;x<size;x++){
        question=(ArrayList)questions.get(x);
        word=(String)question.get(0);
        created=(String)question.get(1);
  //delete="qdelete.jsp?id="+question.get(1);
  //view="qview.jsp?id="+question.get(1);
  //update="qupdate.jsp?id="+question.get(1);
                                                      %>
							<tr>
                    <td><% out.println(question.get(0)); %></td>
                    <td class="center"><% out.println(question.get(1)); %></td>
								
								
								<td class="center">
<a class="btn btn-success" href="<%//=view%>">
<i class="halflings-icon white zoom-in"></i>  
</a>
<a class="btn btn-info" href="<%//=update%>">
<i class="halflings-icon white edit"></i>  
</a>
<a class="btn btn-danger" href="<%//=delete%>">
<i class="halflings-icon white trash"></i> 
</a>
								</td>
							</tr>
							<%
                                                      }
                                                        %>
							
						  </tbody>
					  </table>            
					</div>
				</div>
			</div>


    

	</div>
	
			
		</div>
		</div>
		
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
	
	<footer>

		<p>
			<span style="text-align:left;float:left">&copy; 2013 <a href="http://jiji262.github.io/Bootstrap_Metro_Dashboard/" alt="Bootstrap_Metro_Dashboard">Bootstrap Metro Dashboard</a></span>
			
		</p>

	</footer>
	


		<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="js/jquery.ui.touch-punch.js"></script>
	
		<script src="js/modernizr.js"></script>
	
		<script src="js/bootstrap.min.js"></script>
	
		<script src="js/jquery.cookie.js"></script>
	
		<script src='js/fullcalendar.min.js'></script>
	
		<script src='js/jquery.dataTables.min.js'></script>

		<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	
		<script src="js/jquery.chosen.min.js"></script>
	
		<script src="js/jquery.uniform.min.js"></script>
		
		<script src="js/jquery.cleditor.min.js"></script>
	
		<script src="js/jquery.noty.js"></script>
	
		<script src="js/jquery.elfinder.min.js"></script>
	
		<script src="js/jquery.raty.min.js"></script>
	
		<script src="js/jquery.iphone.toggle.js"></script>
	
		<script src="js/jquery.uploadify-3.1.min.js"></script>
	
		<script src="js/jquery.gritter.min.js"></script>
	
		<script src="js/jquery.imagesloaded.js"></script>
	
		<script src="js/jquery.masonry.min.js"></script>
	
		<script src="js/jquery.knob.modified.js"></script>
	
		<script src="js/jquery.sparkline.min.js"></script>
	
		<script src="js/counter.js"></script>
	
		<script src="js/retina.js"></script>

		<script src="js/custom.js"></script>
	
	
</body>
</html>
