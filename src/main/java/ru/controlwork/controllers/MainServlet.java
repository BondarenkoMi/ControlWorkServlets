package ru.controlwork.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.controlwork.dao.Order;
import ru.controlwork.services.OrderService;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Order> orders = OrderService.getAllOrders(req);
        req.setAttribute("orders", orders);
        req.setAttribute("title", "Все заказы");
        req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
    }
}
