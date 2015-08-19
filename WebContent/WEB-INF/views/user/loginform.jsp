<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- ${param.error } -->
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"/>
		</div>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post"
					action="login">
					<c:if test="${param.error =='true'}">
					<p class="error">이메일과 비밀번호가 일치하지 않습니다.</p>
					</c:if>
					<label class="block-label" for="email">이메일</label> <input
						id="email" name="email" type="text"> <label
						class="block-label">패스워드</label> <input name="password"
						type="password"> <input type="submit" value="로그인">

				</form>
			</div>
		</div>
		<div id="navigation">
					<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="pageName" value="user"/>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp"/>

		</div>
	</div>
</body>
</html>