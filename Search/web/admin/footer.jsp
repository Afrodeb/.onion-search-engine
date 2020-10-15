	
	<footer>

		<p>
			<span style="text-align:left;float:left">&copy; 2016 <a href="http://jiji262.github.io/Bootstrap_Metro_Dashboard/" alt="Bootstrap_Metro_Dashboard">Bootstrap Metro Dashboard</a></span>
			
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
                <script src="js/chat.js"></script>
                <script type="text/javascript">
                $("#cog").hide();    
                var eventSource = new EventSource("notifications.jsp");
		eventSource.onmessage = function(event) {
                        var notifications=event.data;
                        notifications=notifications.replace("[","");
                        notifications=notifications.replace("]","");
                         notifications=notifications.replace("undefined","");
                        var arr =notifications.split(",");
                $(".notso").remove();
        for(var x=0;x<arr.length;x++){
            var message=arr[x].split("-");
 var noty="<li class='notso'>"+
          "<a href='chat.jsp?id="+message[0]+"'>"+
          "<span class='icon blue'><i class='icon-user'></i></span>"+
          "<span class='message'>"+message[1].substring(0,32)+"</span>"+
          "<span class='time'>"+message[2].substring(3,5)+"</span>"+ 
          "</a>"+
          "</li>";
    $("#n").append(noty);
        }    
                        
		};
                
                 var eventSource2 = new EventSource("newmessages.jsp");
		eventSource2.onmessage = function(event2) {
                       var messages=event2.data;
                        messages=messages.replace("[","");
                        messages=messages.replace("]","");
                         messages=messages.replace("undefined","");
                         var arr =messages.split(",");
                $(".bubble").remove();
                console.log(messages);
        for(var x=0;x<arr.length;x++){
            var msg=arr[x];
if(msg.indexOf("You") === -1){
 msg=msg.replace("You","Patient");
// msg=msg.replace("Dr Fortue","Bot");
 var noty="<div class='bubble'>"+
              "<p>"+msg+"</p>"+
	  "</div>";
  }else{
       msg=msg.replace("You","Patient");
// msg=msg.replace("Dr Fortue","Bot");

      var noty="<div class='bubble bubble-alt green'>"+
		  "<p>"+msg+"</p>"+
               "</div>";
  }
    $("#msgs").append(noty);
        }    
                        
		};
                
                $("#submit").click(function(){
                    var msg=$("#msg").val();
                    var id=$("#to").val();
  $.ajax({
                 
                    type: "POST",
                    url: "dosend.jsp",
                    data: "msg=" +msg+"&id="+id,
                    contentType:"application/x-www-form-urlencoded",
                    success: function(result) {
                    	//alert(result);
                    	//$("#qty").val("");
                         var noty="<div class='bubble'>"+
                                   "<p>"+msg+"</p>"+
	                          "</div>";
                          $("#msgs").append("Bot:"+noty);
                   }  
                   
                    });	
                    
                });

                    $("#scrap").click(function(){
                   $("#cog").show();    
                   var web=$("#web").val();
  $.ajax({
                 
                    type: "POST",
                    url: "doscrap.jsp",
                    data: "web=" +web,
                    contentType:"application/x-www-form-urlencoded",
                    success: function(result) {
                         alert(result);
                         $("#cog").hide();    
                   }  
                   
                    });	
                    
                });
    
     $("#classifier").click(function(){
                  $("#cog").show();    
  $.ajax({
                 
                    type: "POST",
                    url: "miner.jsp",
                    contentType:"application/x-www-form-urlencoded",
                    success: function(result) {
        $("#cog").hide();                     
        alert(result);
                         
                         location.reload();
                    
                   }  
                   
                    });	
                    
                });
                    
                         $("#model").click(function(){
                  $("#cog").hide();    
  $.ajax({
                 
                    type: "POST",
                    url: "createmodel.jsp",
                    contentType:"application/x-www-form-urlencoded",
                    success: function(result) {
                        $("#cog").hide();    
                         alert(result);
                          location.reload();
                   }  
                   
                    });	
                    
                });
                    
                </script>
	
</body>
</html>
