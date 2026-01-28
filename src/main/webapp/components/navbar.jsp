<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="assets/css/style.css">

<div class="navbar">
  <div>
    
    <a href="${pageContext.request.contextPath}/products">Store</a>
    <a href="${pageContext.request.contextPath}/cart">Cart</a>
    
    <%-- Show Dashboard only if logged in --%>
        <% if (session.getAttribute("userId") != null) { %>
            <a href="<%= request.getContextPath() %>/customer/dashboard.jsp">
                Dashboard
            </a>
        <% } %>
  </div>

   <div>
        <% if (session.getAttribute("userId") == null) { %>

            <!-- NOT LOGGED IN -->
            <a href="<%= request.getContextPath() %>/login.jsp">Login</a>
            <a href="<%= request.getContextPath() %>/register.jsp">Register</a>

        <% } else { %>

            <!-- LOGGED IN -->
            <span style="margin-right: 12px;">
                👤 <%= session.getAttribute("userName") %>
            </span>

            <a href="<%= request.getContextPath() %>/logout">Logout</a>

        <% } %>
    </div>
</div>
