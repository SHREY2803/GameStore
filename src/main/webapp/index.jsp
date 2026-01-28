<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>GameStore | Home</title>
  <link rel="stylesheet" href="assets/css/style.css">
  <link rel="icon" type="image/png" href="./assets/images/page_favicon.png">
</head>

<body>

<jsp:include page="components/navbar.jsp" />

<div class="container">
  <h2>Featured Games</h2>

  <div class="game-grid">

    <div class="game-card">
      <img src="assets/images/game1.jpg">
      <h3>Cyber Quest</h3>
      <p>Action • Adventure</p>
      <a href="product-details.jsp" class="btn">View Details</a>
    </div>

    <div class="game-card">
      <img src="assets/images/game2.jpg">
      <h3>Shadow Arena</h3>
      <p>Multiplayer • Battle</p>
      <a href="product-details.jsp" class="btn">View Details</a>
    </div>

  </div>
</div>

<jsp:include page="components/footer.jsp" />

</body>
</html>
