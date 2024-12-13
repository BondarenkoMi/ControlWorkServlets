package ru.controlwork.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.controlwork.dao.Order;
import ru.controlwork.services.OrderService;

import java.io.IOException;

@WebServlet("/orders/")
public class OrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int orderId = Integer.parseInt(req.getParameter("num"));
        Order order = OrderService.getOrderById(orderId, req);
        if (order != null) {
            req.setAttribute("order", order);
            req.setAttribute("title", "Заказ");
        } else {
            resp.setStatus(404);
            req.getRequestDispatcher("/WEB-INF/404.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/WEB-INF/order.jsp").forward(req, resp);
    }

}
