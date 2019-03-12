<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
	function getemployee(){
		$.ajax({
			type: 'GET',
			url: 'employees',
			dataType: 'json',
			success: function(res){
				console.log(res);
				var new_row;
				for(var i=0; i<res.length; i++){
					var j=i+1;
					
					new_row += "<tr>"
						+"<td>"+ j +"</td>"
						+"<td>" + res[i].name + "</td>"
						+"<td>" + res[i].designation + "</td>"
						+"<td>" + res[i].salary + "</td>"
						+"<tr>"
						$("table tbody").html(new_row);
				}
			},
			error: function(){
				alert("something is wrong");
			}
		});
	}
	
	$(document).ready(function(){
		
		var employeeForm = $("#employee-form")
		
		addChapterForm.submit(function(e){
			e.preventDefault();
			$.ajax({
				type: addChapterForm.attr('method'),
				url: addChapterForm.attr('action'),
				data: addChapterForm.serialize(),
				headers : {
					"Content-Type": 'application/json',
					"Accept": 'application/json'
				},
				success: function(res){
					console.log("data save successfully !!");
					
				},
				error: function(){
					alert("something is wrong");
				}
			});
		});

		
	});
</script>
</head>

<body>
	<h1>Employee Information</h1>
	
	<div class="col-xs-12">
		<div class="col-xs-3"><a href="javascript:void();" class="btn btn-success" onclick="getemployee();">Get Employee</a></div>
		<div class="col-xs-3"><a href="javascript:void();" class="btn btn-success" onclick="saveEmployee();">Add Employee</a></div>
		<div class="col-xs-6"></div>
	</div>
	
	<div class="col-xs-12">
		<div class="col-xs-6">
		<form action="employee" method="post" id="employee-form">
			<input type="text" name="name" class="form-control">
			<input type="text" name="designation" class="form-control">
			<input type="text" name="salary" class="form-control">
			<input type="submit" value="Submit" class="btn btn-primary"> 
		</form>
		</div>
		<div class="col-xs-6"></div>
	</div>
	<div class="col-xs-12">
	<table class="table table-striped">
		<thead>
			<th>Employee ID</th>
			<th>Name</th>
			<th>Designation</th>
			<th>Salary</th>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	</div>
</body>
</html>