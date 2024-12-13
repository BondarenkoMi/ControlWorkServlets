package ru.controlwork.services;

import jakarta.servlet.http.HttpServletRequest;
import ru.controlwork.dao.Order;
import ru.controlwork.services.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public static List<Order> getAllOrders(HttpServletRequest request) {
        List<Order> orders = new ArrayList<>();
        DBConnection dbConnection = (DBConnection) request.getServletContext().getAttribute("dbConnection");
        Connection connection = dbConnection.getConnection();
        String sql = "select * from orders";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dishes = resultSet.getString("dishes");
                int tableId = resultSet.getInt("table_num");
                String waiter = resultSet.getString("waiter");
                Order order = new Order(id, dishes, tableId, waiter);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public static Order getOrderById(int id, HttpServletRequest request) {
        DBConnection dbConnection = (DBConnection) request.getServletContext().getAttribute("dbConnection");
        Connection connection = dbConnection.getConnection();
        String sql = "select * from orders where id = ?";
        Order order = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                String dishes = resultSet.getString("dishes");
                int tableId = resultSet.getInt("table_num");
                String waiter = resultSet.getString("waiter");
                order = new Order(orderId, dishes, tableId, waiter);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }
}
