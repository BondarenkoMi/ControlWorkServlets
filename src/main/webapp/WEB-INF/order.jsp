<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2>Номер заказа: ${order.id}</h2>
<h3>Состав заказа: ${order.dishes}</h3>
<h4>Номер столика: ${order.tableNumber}</h4>
<h5>Официант: ${order.waiter}</h5>
</body>
</html>
