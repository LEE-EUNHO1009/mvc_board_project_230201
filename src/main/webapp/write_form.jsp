<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="500">
		<form action="write.do">
			<tr>
				<td>제 목</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>내 용</td>
				<td><textarea name="bcontent" rows="10" cols="40"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="button" value="취소" onclick="javascript:window.location=''">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>