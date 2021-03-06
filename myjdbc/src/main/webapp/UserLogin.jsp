<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>LogIn</title>

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
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="LoginController" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="E-mail" name="email"
										type="email" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password">
								</div>
								<div class="checkbox">
									<label> <a href="forgetPass.jsp">Forget Password ?</a>
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<input type="submit" class="btn btn-lg btn-success btn-block"
									value="Login"> <a href="Registration.jsp"
									class="btn btn-lg btn-primary btn-block">Create Account</a>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${not empty success}">
		<script>
			alert("Your Registration Successful ! Please Login");
		</script>
	</c:if>
	<c:if test="${not empty loginFailed}">
		<script>
			alert("Sorry ! Email or Password Wrong Please try Again !");
		</script>
	</c:if>
	<c:if test="${not empty logout}">
		<script>
			alert("Logout Successfully !");
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

</body>
</html>
