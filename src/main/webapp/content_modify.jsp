<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
</head>
<body>
	<h2>게시판 글 수정</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<form action="modify.do" method="post">
		<input type="hidden" value="${dto.bid }" size="80" name="bid">
		<tr>
			<td colspan="4">
				<input type="text" value="${dto.btitle }" size="80" name="btitle">
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${dto.bdate }</td>
			<td>조회수</td>
			<td>${dto.bhit }</td>
		</tr>
		<tr>
			<td colspan="4" height="100">
				<textarea rows="10" cols="50" name="bcontent">${dto.bcontent }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="submit" value="수정완료">				
				<input type="button" value="취소" onclick="javascript:window.location='list.do'">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>