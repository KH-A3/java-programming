<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome JSP/Servlet</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/navigation.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/paging.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/required.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/table.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/required.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<h1>Welcome JSP/Servlet</h1>
	<div>
		<h2>JSTL Core 기능 테스트</h2>
		<c:set var="d" value="Hello1" scope="page" />
		<c:set var="d" value="Hello2" scope="request" />
		<c:set var="d" value="Hello3" scope="session" />
		<c:set var="d" value="Hello4" scope="application" />
		${pageScope.d}<br>
		${requestScope.d}<br>
		${sessionScope.d}<br>
		${applicationScope.d}<br>
		<hr>
		<c:remove var="d" scope="page" />
		<c:remove var="d" scope="request" />
		<c:remove var="d" scope="session" />
		<c:remove var="d" scope="application" />
		${pageScope.d}<br>
		${requestScope.d}<br>
		${sessionScope.d}<br>
		${applicationScope.d}<br>
		<hr>
		<c:url var="url1" value="/path">
			<c:param name="x" value="10" />
		</c:url>
		${url1}
	</div>
</body>
</html>