<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp">
			</c:import>
		</div>
		<div id="content">
			<div id="board">
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="status" value="${fn:length(list)}">
					</c:set>
					<c:forEach var="vo" items="${list }" varStatus="status">
						<tr>
							<td>[${status.index }]</td>
							<td><a href="/board/view/${vo.no}">${vo.title }</a></td>
							<td>${vo.memberName }</td>
							<td>${vo.viewCnt }</td>
							<td>${vo.regDate }</td>
							<td>
							<c:if test="${vo.memberNo == authUser.no }">
							<a href="/board/delete/${vo.no}"><img src="/assets/images/recycle.png" ></a>
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>

				<table class="tbl-page">
					<tr>
						<td colspan="5"><a href="/board/1">처음</a> <c:if
								test="${c_page>1}">
								<a href="/board/${c_page-1}">이전</a>
							</c:if> <c:if test="${c_page<=1}">
								<a href="/board/${c_page}">이전</a>
							</c:if> <c:forEach var="i" begin="${s_page }" end="${c_m_page }">
								<c:if test="${i==c_page }">
									${i}
								</c:if>
								<c:if test="${i!=c_page }">
									<a href="/board/${i}">${i}</a>
								</c:if>
							</c:forEach> <c:if test="${c_page>=t_page}">
								<a href="/board/${c_page }">다음</a>
							</c:if> <c:if test="${c_page<t_page}">
								<a href="/board/${c_page+1}">다음</a>
							</c:if> <a href="/board/${t_page}"> 맨끝</a></td>
					</tr>
				</table>
				<div class="bottom">
					<c:if test="${not empty authUser}">
						<a href="/board/writeform" id="new-book">글쓰기</a>
					</c:if>
					<c:if test="${not empty detail}">
						<a href="/board/" id="new-book">목록으로</a>
					</c:if>
					<form id="search_form" action="/board/1" method="post">
					<input type="text" id="kwd" name="kwd" value=""> 
					<input type="submit" value="찾기">
				</form>
				</div>
				
			</div>

		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="pageName" value="board" />
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp">
			</c:import>
		</div>
	</div>
</body>
</html>