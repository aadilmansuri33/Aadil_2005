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

	<form action="Test" method="post">
		<input type="text" name="line"> <br> <input type="text"
			name="street"> <br> <input type="text" name="area">
		<br> <input type="text" name="landmark"> <br> <input
			type="text" name="city"> <br> <input type="text"
			name="state"> <br> <input type="text" name="country">
		<br> <input type="submit" value="submit">
	</form>
	<c:forEach items="${map }" var="map">
		<c:out value="${map.line }"></c:out>
		<c:out value="${map.street }"></c:out>
		<c:out value="${map.area }"></c:out>
		<c:out value="${map.landmark }"></c:out>
		<c:out value="${map.city}"></c:out>
		<c:out value="${map.state }"></c:out>
		<c:out value="${map.country }"></c:out>
		<br>
	</c:forEach>
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
