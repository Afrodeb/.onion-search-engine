<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.varwere"%>
<%@include file="header.jsp" %>
<%
varwere varw=new varwere();
ArrayList patients,doctors,patient=new ArrayList();
patients=varw.clients();
doctors=varw.admins();
int num=patients.size();
int doc=doctors.size();
String id=request.getParameter("id");
session.setAttribute("pid",id);
ArrayList p=varw.getPatient(id.trim());
ArrayList messages=varw.getMessages(id.trim());
//out.print(messages.toString());
%>

			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
                                <li><a href="#">Chat</a></li>
			</ul>	

       <div class="row-fluid">
    <div class="col-md-8">
        <div class="panel panel-info">
            <div class="panel-heading">
                The following is a chat between the bot and <% out.println(p.get(0));%> 
              
            </div>
            <div class="panel-body">
<ul class="media-list">
<div class="panel-footer">
     <form action="dosend.jsp" method="post">
                <div class="input-group">
                    <input type="hidden" value="<% out.print(id); %>" id="to" name="id">
                    <input style="width: 800px;height: 40px;" id="msg" type="text" name="message" class="form-control" placeholder="Enter Message" />
                                    <br><span class="input-group-btn">
                   <input type="submit" class="btn btn-info" type="button" id="submito" value="SEND" />
                                    </span>
                   
                                </div>
          </form>
            </div>
    <br><br><br><br><br><br>
                                    <li class="media">

                                        <div class="media-body">
<p class="datestamp">
    <%
    SimpleDateFormat sdf=new SimpleDateFormat("dd-M-yyyy HH:mm");
    Calendar calendar=new GregorianCalendar();
    int year=calendar.get(Calendar.YEAR);
    int month=calendar.get(Calendar.MONTH);
    int day=calendar.get(Calendar.DAY_OF_MONTH);
    int hour=calendar.get(Calendar.HOUR_OF_DAY);
    int minute=calendar.get(Calendar.MINUTE);
    String dateInString=Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year)+" "+Integer.toString(hour)+":"+Integer.toString(minute);
    //out.println(sdf.parse(dateInString));
    %>
    </p>
<% //if(session.getAttribute("convo")!=null){
     //      messages=(ArrayList)session.getAttribute("convo");  
           int size=messages.size();
           for(int x=size-1;x>=0;x--){
%>
    

    <div class="container" id="msgs">
   
<%
if(messages.get(x).toString().indexOf("You") == -1){
String msg=(String)messages.get(x);
msg=msg.replace("Dr Fortue","Bot");
msg=msg.replace("You:",(String)p.get(0)+":");
%>
	  <div class="bubble">
              <p><% out.print(msg); %></p>
	  </div>
<%
}else {
    String msg=(String)messages.get(x);
    msg=msg.replace("You:",(String)p.get(0));
    msg=msg.replace("Dr Fortue","Bot");
%>
	  <div class="bubble bubble-alt green">
              
		  <p><% out.print(msg); %></p>
	  </div>
<%
}
%>	
  </div>                                                  
                                                    <br />
                                                                                                 <hr />
                                               <!-- </div>
                                            </div>-->

   <%
   }        
 //  }
   %>                                         
                                            <div class="media">
                                                <div class="media-body" >
<% if(session.getAttribute("name")!=null && !session.getAttribute("name").equals("")){
     }else{
}
           %>
                                                    
                                                    <br />
                                                                                                 <hr />
                                                </div>
                                            </div>

                                        </div>
                                    </li>
     
   
                                </ul>
            </div>
            
        </div>
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