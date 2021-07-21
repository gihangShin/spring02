<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<title>Insert Message</title>
</head>
<body>
	<section>
		<h2>insert Message</h2>
		<form method="post" action="insertMessage.do">
			<div class="row gtr-uniform">
				<div class="col-6 col-12-xsmall">
					<input type="text" name="writer" id="writer" value=""
						placeholder="Name" />
				</div>
				<div class="col-12">
					<textarea name="content" id="content"
						placeholder="Enter your message" rows="6"></textarea>
				</div>
				<div class="col-12">
					<ul class="actions">
						<li><input type="submit" value="Send Message" class="primary" /></li>
						<li><input type="reset" value="Reset" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
</body>
</html>