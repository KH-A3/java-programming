<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, locs.model.LocsDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 조회 결과</title>
</head>
<script type="text/javascript">
window.onload = function() {
	var form = document.forms[0];
	form.addEventListener("submit", formCheck);
}

function formCheck(e) {
	var f = e.target;
	e.preventDefault();
	
	if(f.search.value.trim() === "") {
		f.search.value = f.search.value.trim();
		return;
	}
	f.submit();
}
</script>
<body>
	<h1>지역 조회 결과</h1>
	<div>
		<form action="./locs" method="get">
			<div>
				<input type="text" name="search">
				<button type="submit">조회</button>
			</div>
		</form>
	</div>
	<table>
		<tr>
			<th>Location ID</th>
			<th>Street Address</th>
			<th>Postal Code</th>
			<th>City</th>
			<th>State Province</th>
			<th>Country Id</th>
		</tr>
		<%
			if(request.getAttribute("datas") != null) {
				List<LocsDTO> datas = (List<LocsDTO>)request.getAttribute("datas");
				for(LocsDTO data: datas) {
		%>
					<tr>
						<td><%=data.getLocId() %></td>
						<td><%=data.getStAddr() %></td>
						<td><%=data.getPostal() %></td>
						<td><%=data.getCity() %></td>
						<td><%=data.getState() %></td>
						<td><%=data.getCtyId() %></td>
					</tr>
		<%
				}
			} else {
		%>
			<tr>
				<td colspan="6">검색 결과가 없습니다.</td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>