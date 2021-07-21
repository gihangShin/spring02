<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Stellar by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Message List</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<h1>Message List</h1>
		</header>

		<!-- Main -->
		<div id="main">

			<!-- Content -->
			<section id="content" class="main">
				<span class="image main"><img src="images/pic04.jpg" alt="" /></span>
				<h2>Message List</h2>
				<!-- 여기 메세지 리스트 작성 -->
				<c:forEach items="${msgList}" var="v">
					<table>
						<tr>
							<td>messageID</td>
							<td><a href="getMessage.do?mid=${v.mid}">${v.mid}</a></td>
						</tr>
						<tr>
							<td>writer</td>
							<td>${v.writer}</td>
						</tr>
						<tr>
							<td>content</td>
							<td>${v.content}</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><a href="deleteMessage.do?mid=${v.mid}">삭제하기</a></td>
						</tr>
					</table>
				</c:forEach>
			</section>
			<a href="index.jsp">home</a>

		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>