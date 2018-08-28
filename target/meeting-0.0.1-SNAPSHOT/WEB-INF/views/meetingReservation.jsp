
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Metting Reservation140</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="//code.jquery.com/jquery.min.js"></script>
		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
		<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

		<!-- JavaScript -->
		<script type="text/javascript">
		$(function() {
			  $( "#datepicker1" ).datepicker({
			    dateFormat: 'yymmdd'
			  });
			  $( "#datepicker2" ).datepicker({
				    dateFormat: 'yymmdd'
				  });
			  $( "#timepicker1").timepicker({
				    timeFormat: 'HH:mm',
				    interval: 30,
				    startTime: '00:00',
				    dynamic: false,
				    dropdown: true,
				    scrollbar: true
				});
			  $( "#timepicker2").timepicker({
				    timeFormat: 'HH:mm',
				    interval: 30,
				    startTime: '00:00',
				    dynamic: false,
				    dropdown: true,
				    scrollbar: true
				});
			});
	 		$("#mettingReservation").submit(function(event){
	            event.preventDefault();
	            
	            var formData = {
            		mettingRoomName : $("#mettingRoomName").val(),
            		start :  $("#start").val(),
            		end :  $("#end").val(),
            		user :  $("#user").val(),
            		cycleCount :  $("#cycleCount").val()
            	}
	            
	            $.ajax({
	                type : 'post',
	                url : "metting",
	                contentType: 'application/json; charset=UTF-8',
	                data : JSON.stringify(formData)
	            });
	        });
		</script>
	</head>
	<body>
		<form name="mettingReservation">
			<input type="text" name="mettingRoomName" id="mettingRoomName" placeholder="Metting Room Name"><p>
			<input type="text" name="startDate" id="datepicker1" placeholder="start date">
			<input type="text" name="startTime" id="timepicker1" placeholder="start time"><p>
			<input type="text" name="endDate" id="datepicker2" placeholder="end date">
			<input type="text" name="endTime" id="timepicker2" placeholder="end time"><p>
			<input type="text" name="user" id="user" placeholder="user"><p>
			<input type="text" name="cycleCount" id="cycleCount" placeholder="cycleCount"><p>
			<button type="submit">Save</button>
		</form>
	</body>
</html>