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
			<div id="board" class="board-form" align="left">
				<table class="tbl-ex">
					<tr>
						<th colspan="2"></th>
					</tr>
					<tr>
						<td class="label" align="left" style="width: 100px">제목</td>
						<td>${vo.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">${vo.content}</div>
						</td>
					</tr>
				</table>
				<br>
				<h3>
					댓글목록
					</h2>
					<br>

					<c:forEach var="reply" items="${replyList}">
						<table class="tb-reply">
							<tr>
								<c:if test="${reply.depth==0}">
									<td><img src="/assets/css/images/gc_img.gif"></td></c:if>
								<td class="" style="padding-left:${reply.depth*30}px"><input
									type="hidden" name="articleNo" value=""><strong>${reply.memberName}</strong></td>

								<td>${reply.regDate}</td>
								<td><c:if test="${reply.memberNo == authUser.no }">
										<a
											href="/board/deletereply/${reply.no}?articleNo=${reply.articleNo}"><img
											src="/assets/images/recycle.png"></a>
									</c:if> <c:if test="${not empty authUser}">
										<td><a
											href="/board/replyreplyform?replyNo=${reply.no}&articleNo=${reply.articleNo}"><button
													style="background-color: rgba(58, 137, 201, 0.3)">답글</button></a></td>
									</c:if>
							</tr>
							<tr>
								<td style="padding-left:${reply.depth*30}px" colspan="2"
									valign="top">${reply.content}</td>
							</tr>


						</table>
					</c:forEach>

					<form class="board-reply_form" action="/board/addreply/${vo.no}"
						method="post">
						<input type="hidden" name="no" value="${authUser.no}"> <input
							type="hidden" name="name" value="${authUser.name}">
						<table>
							<tr>
								<td><textarea cols="75" rows="10" maxlength="1000"
										id="content" name="replyContent"></textarea></td>
							</tr>
							<tr>
								<td align="right"><input type="submit" value="답글"></td>
							</tr>
						</table>
					</form>
					<div class="bottom">
						<a href="/board/1">글목록</a>
						<c:if test="${vo.memberNo==authUser.no}">
							<a href="/board/modifyform/${no}">글수정</a>
						</c:if>
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