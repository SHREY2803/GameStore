<%@ page language="java" %>
<link rel="stylesheet" href="assets/css/style.css">
<jsp:include page="components/navbar.jsp" />

<div class="container" style="max-width:420px">

  <h2>Login</h2>

  <form action="login" method="post">
    <input class="input-box" name="email" placeholder="Email">
    <input class="input-box" name="password" type="password" placeholder="Password">
    <button class="btn">Login</button>
  </form>

</div>

<jsp:include page="components/footer.jsp" />
