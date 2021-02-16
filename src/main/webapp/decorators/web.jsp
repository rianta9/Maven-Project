<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- include taglib -->
<%@ include file="/common/taglib.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang Chủ" /></title>

<!-- CSS -->
<link
	href="<c:url value = '/template/web/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value = '/template/web/css/style.css'/>" rel="stylesheet">
</head>
<body>

	<!-- HEADER -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- END HEADER -->

	<!-- CONTENT -->
	<div class="container">
		<dec:body />
	</div>
	<!-- CONTENT -->
	
	
	<!-- FOOTER -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- END FOOTER -->

	<script type="text/javascript"
		src="<c:url value='/template/web/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value = '/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>