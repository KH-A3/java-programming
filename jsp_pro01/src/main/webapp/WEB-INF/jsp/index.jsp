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
		<fmt:formatNumber value="1000" /><br>
		<fmt:formatNumber value="0.1" type="percent" /><br>
		<fmt:formatNumber value="1000" type="currency" /><br>
		<fmt:formatNumber value="1000" type="currency" currencySymbol="$" /><br>
		<hr>
		<c:set var="date" value="<%=new Date() %>" />
		<fmt:formatDate value="${date}" type="date" /><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="full" /><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="long" /><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="medium" /><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="short" /><br>
		<fmt:formatDate value="${date}" type="date" pattern="YYYY-MM-dd E EEEE" /><br>
		<hr>
		<fmt:formatDate value="${date}" type="time" /><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="full" /><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="long" /><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="medium" /><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="short" /><br>
		<fmt:formatDate value="${date}" type="time" pattern="a hh:mm:ss | HH:mm:ss.sss z" /><br>
		<hr>
		<fmt:formatDate value="${date}" type="both" /><br>
		<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="medium" /><br>
		<hr>
		${fn:contains('Hello', 'e')}<br>
		${fn:containsIgnoreCase('Hello', 'E')}<br>
		${fn:startsWith('Hello', 'e')}<br>
		${fn:endsWith('Hello', 'e')}<br>
		${fn:indexOf('Hello', 'e')}<br>
		${fn:length('Hello')}<br>
		${fn:replace('Hello', 'e', 'a')}<br>
		${fn:substring('Hello', 1, 3)}<br>
		${fn:split('Hello, Hi', ', ')}<br>
		${fn:join(fn:split('Hello, Hi', ', '), '-')}<br>
		${fn:trim('  Hello  ')}<br>
	</div>
</body>
</html>