
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Home</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="startmin-master/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<c:url value="startmin-master/css/metisMenu.min.css"/>"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="<c:url value="startmin-master/css/timeline.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="startmin-master/css/startmin.css"/>"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<c:url value="startmin-master/css/morris.css"/>"
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

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">JAVA</a>
			</div>

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- /.navbar-top-links -->
			<ul class="nav navbar-right navbar-top-links">
				<c:choose>
					<c:when test='${sessionScope.Login ne null}'>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>Welcome
								<c:out value='${sessionScope.firstName }'></c:out> <b
								class="caret"></b>
						</a>
							<ul class="dropdown-menu dropdown-user">
								<li class="divider"></li>
								<li><a href="LoginController?action=logout"><i
										class="fa fa-sign-out fa-fw"></i> Logout</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="UserLogin.jsp">Login </a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<c:if test="${sessionScope.Login ne null }">
				<div class="navbar-default sidebar" role="navigation">
					<div class="sidebar-nav navbar-collapse">
						<ul class="nav" id="side-menu">
							<c:choose>
								<c:when test="${sessionScope.userRoleId == 1 }">
									<li><a href="UserController?action=data" class="active"><i
											class="fa fa-users fa-fw"></i> Users</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="Users.jsp" class="active"><i
											class="fa fa-users fa-fw"></i> Details</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</c:if>
		</nav>
		<c:choose>
			<c:when
				test="${sessionScope.Login ne null && SessionScope.userRoleId == 1}">
				<div id="page-wrapper">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Dashboard</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-comments fa-5x"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">26</div>
											<div>New Comments!</div>
										</div>
									</div>
								</div>
								<a href="#">
									<div class="panel-footer">
										<span class="pull-left">View Details</span> <span
											class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

										<div class="clearfix"></div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-green">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-tasks fa-5x"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">12</div>
											<div>New Tasks!</div>
										</div>
									</div>
								</div>
								<a href="#">
									<div class="panel-footer">
										<span class="pull-left">View Details</span> <span
											class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

										<div class="clearfix"></div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-yellow">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-shopping-cart fa-5x"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">124</div>
											<div>New Orders!</div>
										</div>
									</div>
								</div>
								<a href="#">
									<div class="panel-footer">
										<span class="pull-left">View Details</span> <span
											class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

										<div class="clearfix"></div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-red">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-support fa-5x"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">13</div>
											<div>Support Tickets!</div>
										</div>
									</div>
								</div>
								<a href="#">
									<div class="panel-footer">
										<span class="pull-left">View Details</span> <span
											class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

										<div class="clearfix"></div>
									</div>
								</a>
							</div>

						</div>
					</div>
					<!-- /.row -->
					<!-- /.row -->
				</div>
			</c:when>
		</c:choose>
		<!-- /#page-wrapper -->
		<div style="margin-top: 30%; text-align: center">
			<a href="Test?action=test&&userid=${sessionScope.userId }">CLick</a>
		</div>
	</div>
	<!-- /#wrapper -->
	<c:if test="${not empty loginSucess}">
		<script>
			alert("You are Logged in Successfully");
		</script>
	</c:if>
	<c:if test="${not empty deleteSuccess}">
		<script>
			alert("Data Deleted Successfully !");
		</script>
	</c:if>

	<!-- jQuery -->
	<script src="<c:url value="startmin-master/js/jquery.min.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="startmin-master/js/bootstrap.min.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="startmin-master/js/metisMenu.min.js"/>"></script>

	<!-- Morris Charts JavaScript -->
	<script src="<c:url value="startmin-master/js/raphael.min.js"/>"></script>
	<script src="<c:url value="startmin-master/js/morris.min.js"/>"></script>
	<script src="<c:url value="startmin-master/js/morris-data.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="startmin-master/js/startmin.js"/>"></script>

</body>
</html>
