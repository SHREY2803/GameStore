<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>Payment</title>
  <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>

<jsp:include page="components/navbar.jsp" />

<div class="container" style="max-width:420px">

  <h2>Payment Details</h2>

  <form>

    <input class="input-box" placeholder="Card Number">
    <input class="input-box" placeholder="Card Holder Name">
    <input class="input-box" placeholder="Expiry (MM/YY)">
    <input class="input-box" type="password" placeholder="CVV">

    <a href="order-confirmation.jsp" class="btn">Pay Now</a>

  </form>

</div>

<jsp:include page="components/footer.jsp" />

</body>
</html>
