<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="_header.jsp" %>
<c:forEach var="order" items="${orders}">
    <a href="/orders/?num=${order.id}">
        <h2 class="order-name">Номер заказа: ${order.id}</h2>
    </a>
    <p>Номер столика: ${order.tableNumber}</p>
    <p>Официант: ${order.waiter}</p>
    <hr>
</c:forEach>
</body>
</html>
