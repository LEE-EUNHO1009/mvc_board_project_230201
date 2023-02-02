<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 내용 보기</title>
</head>
<body>
	<h2>게시판 글 내용 보기</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<tr>
			<td colspan="4">${dto.btitle }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${dto.bdate }</td>
			<td>조회수</td>
			<td>${dto.bhit }</td>
		</tr>
		<tr>
			<td colspan="4" height="100">${dto.bcontent }</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="수정" onclick="javascript:window.location=''"> 
				<input type="button" value="삭제" onclick="javascript:window.location=''"> 
				<input type="button" value="목록" onclick="javascript:window.location='list.do'"> 
			</td>
		</tr>
	</table>
</body>
</html>