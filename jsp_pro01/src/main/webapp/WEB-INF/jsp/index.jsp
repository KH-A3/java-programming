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
		${1 == '1'} / ${1 == 1}
		
		<c:if test="${not empty data}">
			if 제어문 : test 에 작성한 조건식이 참이면 실행된다.<br>
			${data}
		</c:if>
		<hr>
		<c:choose>
			<c:when test="${param.x == 'a'}">
				파라메터 x 의 값이 a 입니다.
			</c:when>
			<c:when test="${param.x == 'b'}">
				파라메터 x 의 값이 b 입니다.
			</c:when>
			<c:when test="${param.x == 'c'}">
				파라메터 x 의 값이 c 입니다.
			</c:when>
			<c:otherwise>
				파라메터 x 의 값이 a, b, c 가 아닙니다.
			</c:otherwise>
		</c:choose>
		<hr>
		<c:forEach begin="5" end="10" step="2" var="v">
			${v}<br>
		</c:forEach>
		<%
			List<String> lst = new ArrayList<String>();
			lst.add("a"); lst.add("b"); lst.add("c"); lst.add("d");
			request.setAttribute("lst", lst);
		%>
		<c:forEach items="${lst}" var="v">
			${v}<br>
		</c:forEach>
		<%
			Map<String, String> map = new HashMap<String, String>();
			map.put("a", "가"); map.put("b", "나"); map.put("c", "다");
			request.setAttribute("map", map);
		%>
		<c:forEach items="${map}" var="v">
			${v.key} - ${v.value}<br>
		</c:forEach>
	</div>
</body>
</html>