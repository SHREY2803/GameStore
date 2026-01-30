<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>User Profile</title>
  <link rel="stylesheet" href="../assets/css/style.css">
  <link rel="icon" type="image/png" href="./../assets/images/page_favicon.png">
</head>

<body>

<jsp:include page="../components/navbar.jsp" />

<div class="container">

  <h2>Profile</h2>

  <p>Name: Demo User</p>
  <p>Email: user@example.com</p>

  <button class="btn">Edit Profile</button>

</div>

<jsp:include page="../components/footer.jsp" />

</body>
</html>
