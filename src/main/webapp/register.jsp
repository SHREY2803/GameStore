<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Create Account</title>
<link rel="stylesheet" href="assets/css/style.css">
<link rel="icon" type="image/png" href="./assets/images/page_favicon.png">
</head>

<body>

	<jsp:include page="components/navbar.jsp" />

	<div class="container" style="max-width: 420px">

		<h2>Create Account</h2>

		<form action="register" method="post">
			<input class="input-box" type="text" name="name" placeholder="Full Name" required> 
			<input class="input-box" type="email" name="email" placeholder="Email" required> 
			<input class="input-box" type="password" name="password" placeholder="Password" required>

			<button class="btn" type="submit">Register</button>
		</form>

	</div>

	<jsp:include page="components/footer.jsp" />

</body>
</html>
