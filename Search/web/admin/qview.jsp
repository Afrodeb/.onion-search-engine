<%@page import="java.util.ArrayList"%>
<%@page import="models.varwere"%>
<%@include file="header.jsp" %>
<%
String id=request.getParameter("id");
varwere varw=new varwere();
String question=varw.getQuestion(id);
ArrayList qna=varw.getQnA(id);

%>
			<div id="content" class="span12">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Home</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-edit"></i>
					<a href="#">View Question details</a>
				</li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon edit"></i><span class="break"></span>Add a possible response the question.</h2>
						
					</div>
	<div class="box-content">
	<form action="doanswer.jsp" method="post" class="form-horizontal">
					
                                                <fieldset>
                                                    <p>
                                                        <b>Question</b>: 
                                                        <%
                                                        out.println(question);
                                                        %>
                                                        
                                                    </p>
                                                    
                                                    <hr>
                                                    <br>
                                                    
<div class="control-group hidden-phone">
<label class="control-label" for="textarea2">Enter an answer here.</label>
	  <div class="controls">
         <textarea name="answer" class="cleditor" id="textarea2" rows="3"></textarea>
         <input type="hidden" name="id" value="<%=id%>">
	  </div>
							</div>
                                                    
                                                    
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary">Save changes</button>
							  <button type="reset" class="btn">Cancel</button>
							</div>
                                                    
                                                    
						  </fieldset>
						</form>   

					</div>
                                                        <%
       int size=qna.size();
       for(int x=0;x<size;x++){
        String answer=varw.getAnswer((String)qna.get(x));
                
                %>
                     <div class="box-content">
						
							<fieldset>
							  <div class="control-group">
								<div class="controls">
                                                                    <p><% out.println(answer); %></p>
								</div>
							  </div>
						  </fieldset>
                     </div>
                     <%
                     }
                     %>
                                                        
                                                        
				</div><!--/span-->

			</div><!--/row-->

		
    

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Finished!</h3>
		</div>
		<div class="modal-body">
			<p>A question has been submitted to the engine,do not forget to add possible response to this question.</p>
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
	
	<!-- start: JavaScript-->

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
	<!-- end: JavaScript-->
	
</body>
</html>
