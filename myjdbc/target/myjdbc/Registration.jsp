<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Registration</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="startmin-master/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<c:url value="startmin-master/css/metisMenu.min.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="startmin-master/css/startmin.css"/>"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="<c:url value="startmin-master/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-1" style="margin-top: 0">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Registration</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="UserController" id="myform"
							method="post" enctype="multipart/form-data">
							<fieldset id="account_information">
								<legend>Personal information</legend>
								<div class="form-group">
									<label>Selects</label> <select class="form-control"
										name="suffix">
										<option value="Mr">Mr.</option>
										<option value="Mrs">Mrs.</option>
										<option value="Ms">Ms</option>
									</select>
								</div>
								<div class="form-group">
									<label>First Name</label> <input type="text" name="firstName"
										id="firstName" class="form-control"
										placeholder="Enter First Name">
								</div>
								<div class="form-group">
									<label>Last Name</label> <input type="text" name="lastName"
										id="lastName" class="form-control"
										placeholder="Enter Last Name">
								</div>
								<div class="form-group">
									<label>Email</label> <input type="email" name="email"
										id="email" class="form-control" placeholder="Enter Email">
								</div>
								<div class="form-group">
									<label>Date of Birth</label> <input type="date"
										name="dateOfBirth" id="dateOfBirth" class="form-control"
										placeholder="Enter Date of Birth">
								</div>
								<div class="form-group">
									<label>Mobile No</label> <input type="number" name="mobileNo"
										id="mobileNo" class="form-control"
										placeholder="Enter Mobile No">
								</div>
								<div class="form-group">
									<label>Alternate No</label> <input type="number"
										name="alternateNo" id="alternateNo" class="form-control"
										placeholder="Enter Alternate No">
								</div>
								<div class="form-group">
									<label>Gender</label> <label class="radio-inline"> <input
										type="radio" name="gender" value="M" checked>Male
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="F">Female
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="O">Other
									</label>
								</div>
								<div class="form-group">
									<label>Password</label> <input type="password" name="password"
										id="password" class="form-control"
										placeholder="Enter Password">
								</div>
								<div class="form-group">
									<label>confirm Password</label> <input type="password"
										name="confi_pass" id="confi_pass" class="form-control"
										placeholder="Confirm Password">
								</div>
								<div class="form-group">
									<label>Select File</label> <input type="file" name="upfile"
										id="upfile" class="form-control" accept=".jpeg,.png,.gif,.jpg">
								</div>
								<hr>
								<!-- Change this to a button or input when using this as a form -->
								<legend>Address</legend>
								<div class="col-md-12">
									<div id="fielda">
										<div id="fielda0">
											<!-- Text input-->
											<div class="form-group">
												<label>Line</label> <input type="text" name="line[]"
													id="line" class="form-control" placeholder="Address Line"
													required>

											</div>
											<div class="form-group">
												<label>Street</label> <input type="text" name="street[]"
													id="street" class="form-control" placeholder="Street"
													required>

											</div>
											<div class="form-group">
												<label>Area</label> <input type="text" name="area[]"
													id="area" class="form-control" placeholder="Area" required>

											</div>
											<div class="form-group">
												<label>Landmark</label> <input type="text" name="famous[]"
													id="landmark" class="form-control" placeholder="Landmark"
													required>

											</div>
											<div class="form-group">
												<label>City</label> <input type="text" name="city[]"
													id="city" class="form-control" placeholder="City" required>

											</div>
											<div class="form-group">
												<label>State</label> <input type="text" name="state[]"
													id="state" class="form-control" placeholder="State"
													required>

											</div>
											<div class="form-group">
												<label>Country</label> <input type="text" name="country[]"
													id="country" class="form-control" placeholder="Country"
													required>

											</div>
											<!-- Text input-->
											<hr>
										</div>
										<!--end field0-->
									</div>
									<!--end field-->
									<!-- Button -->
									<div class="form-group">
										<div class="col-md-4 col-md-offset-8">
											<button id="add-more1" name="add-more"
												class="btn btn-primary">Add More</button>
										</div>
									</div>
								</div>
								<p>
									<input class="btn btn-success" type="submit" value="submit"
										id="submit">
								</p>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${not empty failed}">
		<script>
			alert("Sorry ! Registration Failed ! Please try Again");
		</script>
	</c:if>
	<!-- jQuery -->
	<script src="<c:url value="startmin-master/js/jquery.min.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="startmin-master/js/bootstrap.min.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="startmin-master/js/metisMenu.min.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="startmin-master/js/startmin.js"/>"></script>
	<script
		src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"/>"></script>
	<script src="<c:url value="js/address.js"/>"></script>

</body>
</html>
