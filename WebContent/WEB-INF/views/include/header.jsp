<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1>
	<a href="/">MySite</a>
</h1>
<ul>
	<c:choose>
		<c:when test="${empty authUser.name}">
			<li><a href="/user/loginform">로그인</a>
			<li>
			<li><a href="/user/joinform">회원가입</a>
			<li>
		</c:when>
		<c:otherwise>
			<li><a href="/user/updateform">회원정보수정</a>
			<li>
			<li><a href="/user/logout">로그아웃</a>
			<li>
			<li>${authUser.name}님안녕하세요 ^^<font color="#f00">♥</font></li>
		</c:otherwise>
	</c:choose>



</ul>