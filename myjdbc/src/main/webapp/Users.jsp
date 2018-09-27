<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<!-- DataTables CSS -->
<link
	href="<c:url value="startmin-master/css/dataTables/dataTables.bootstrap.css"/>"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<c:url value="startmin-master/css/dataTables/dataTables.responsive.css"/>"
	rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="<c:url value="startmin-master/css/morris.css"/>"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="<c:url value="startmin-master/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">
<title>Users</title>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">JAVA</a>
		</div>

		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<ul class="nav navbar-right navbar-top-links">
			<c:choose>
				<c:when test='${sessionScope.Login ne null}'>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>Welcome
							<c:out value="${sessionScope.firstName }"></c:out> <b
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
		<!-- /.navbar-top-links --> <c:choose>
			<c:when test='${sessionScope.userRoleId == 1 }'>
				<div class="navbar-default sidebar" role="navigation">
					<div class="sidebar-nav navbar-collapse">
						<ul class="nav" id="side-menu">
							<li><a href="index.jsp" class="active"><i
									class="fa fa-backward fa-fw"></i>Back</a>
						</ul>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<c:if test='${sessionScope.userRoleId == 2 }'>
					<div class="navbar-default sidebar" role="navigation">
						<div class="sidebar-nav navbar-collapse">
							<ul class="nav" id="side-menu">
								<li><a href="index.jsp"><i class="fa fa-backward fa-fw"></i>
										Back</a> <!-- /.nav-second-level --></li>
							</ul>
						</div>
					</div>
				</c:if>
			</c:otherwise>
		</c:choose> </nav>
		<c:choose>
			<c:when test="${sessionScope.Login ne null }">
				<div id="page-wrapper">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">Details</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">DataTable of users</div>
								<!-- /.panel-heading -->
								<div class="panel-body">
									<div class="dataTable_wrapper">
										<table class="table table-striped table-bordered table-hover"
											id="dataTables-example">
											<c:choose>
												<c:when test="${sessionScope.userRoleId == 1}">
													<thead>
														<tr>
															<th>Id</th>
															<th>Role</th>
															<th>Suffix</th>
															<th>First Name</th>
															<th>Last Name</th>
															<th>Email</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${requestScope.users }" var="user">
															<tr>
																<td><c:out value="${user.userId }"></c:out></td>
																<td><c:out value="${user.userRoleId }"></c:out></td>
																<td><c:out value="${user.suffix }"></c:out></td>
																<td><c:out value="${user.firstName }"></c:out></td>
																<td><c:out value="${user.lastName }"></c:out></td>
																<td><c:out value="${user.email }"></c:out></td>
																<td><a
																	href="UserController?action=edit&&id=${user.userId }"
																	class="btn btn-info btn-circle"> <i
																		class="fa fa-edit fa-fw"></i>
																</a> <a
																	href="UserController?action=delete&&userid=${user.userId }"
																	class="btn btn-danger btn-circle"> <i
																		class="fa fa-remove fa-fw"></i>
																</a></td>
															</tr>
														</c:forEach>
													</tbody>
												</c:when>
												<c:otherwise>
													<thead>
														<tr>
															<th>Id</th>
															<th>Suffix</th>
															<th>First Name</th>
															<th>Last Name</th>
															<th>Email</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>

														<tr>
															<td><c:out value="${sessionScope.userId }"></c:out></td>
															<td><c:out value="${sessionScope.suffix }"></c:out></td>
															<td><c:out value="${sessionScope.firstName }"></c:out></td>
															<td><c:out value="${sessionScope.lastName }"></c:out></td>
															<td><c:out value="${sessionScope.email }"></c:out></td>
															<td><a
																href="UserController?action=edit&&userid=${sessionScope.userId }"
																class="btn btn-info btn-circle"> <i
																	class="fa fa-edit fa-fw"></i>
															</a> <a
																href="UserController?action=delete&&userid=${user.userId }"
																class="btn btn-danger btn-circle"> <i
																	class="fa fa-remove fa-fw"></i>
															</a></td>

														</tr>
													</tbody>

												</c:otherwise>
											</c:choose>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>
	<script src="<c:url value="startmin-master/js/jquery.min.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="startmin-master/js/bootstrap.min.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="startmin-master/js/metisMenu.min.js"/>"></script>

	<!-- Morris Charts JavaScript -->
	<script src="<c:url value="startmin-master/js/raphael.min.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="startmin-master/js/startmin.js"/>"></script>
	<script
		src="<c:url value="startmin-master/js/dataTables/jquery.dataTables.min.js"/>"></script>
	<script
		src="<c:url value="startmin-master/js/dataTables/dataTables.bootstrap.min.js"/>"></script>
	<c:if test="${not empty deleteFailed}">
		<script>
			alert("Sorry ! Data is not Deleted ! Please try again");
		</script>
	</c:if>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>
</html>