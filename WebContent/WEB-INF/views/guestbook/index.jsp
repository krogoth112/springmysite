<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	pageContext.setAttribute("newLineChar", "\n");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		</div>
		<div id="content">
			<div id="guestbook">
				<form action="insert" method="post">
					<table border="1" width="500">
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<c:set var="count" value="${fn:length(list) }"></c:set>
				<c:forEach var="vo" items="${list }" varStatus="status">
					<table border="1" width="500">
						<tr>
							<td>[${count-status.index }]</td>
							<td>${vo.name }</td>
							<td>${vo.date }</td>
							<td>${vo.password }</td>
							<td><a href="/guestbook/deleteform/${vo.no}">삭제</a></td>
						</tr>
						<tr>
							<td colspan=4>${fn:replace(vo.message, newLineChar,"<br>") }</td>
						</tr>
					</table>
					<br>
				</c:forEach>

			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="pageName" value="guestbook" />
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>