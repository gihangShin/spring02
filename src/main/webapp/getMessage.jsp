<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<title>getMessage</title>
</head>
<body>
	<section>
		<h2>get Message</h2>
		<form action="updateMessage.do">
			<table>
				<tr>
					<td>messageID</td>
					<td><input type="text" value="${v.mid}" name="mid"></td>
				</tr>
				<tr>
					<td>writer</td>
					<td><input type="text" value="${v.writer}" name="writer"></td>
				</tr>
				<tr>
					<td>content</td>
					<td><input type="text" value="${v.content}" name="content"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="수정하기"></td>
				</tr>
			</table>
			<a href="getMessageList.do">돌아가기</a>
		</form>
	</section>
</body>
</html>