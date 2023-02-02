<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h2>게시판 전체 글 목록</h2>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="600">
		<tr>
			<td>번호</td>
			<td width="300">제목</td>
			<td>글쓴이</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		
		<c:forEach items="${dtoList }" var="dto">
		<tr>
			<td>${dto.bid }</td>
			<td><a href="contentView.do">${dto.btitle }</a></td>
			<td>${dto.bname }</td>
			<td>${dto.bdate }</td>
			<td>${dto.bhit }</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5" align="right">
				<input type="button" value="글쓰기" onclick="javascript:window.location='writeForm.do'"> 
			</td>
		</tr>
	</table>
</body>
</html>