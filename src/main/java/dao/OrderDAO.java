package dao;

import java.util.List;

import model.Order;
import model.OrderItem;
public interface OrderDAO {
	// Create new order and return generated orderId
    int createOrder(Order order);

    // Add items to an order
    void addOrderItems(int orderId, List<OrderItem> items);

    // Get all orders of a user
    List<Order> getOrdersByUser(int userId);

    // Get items of a specific order
    List<OrderItem> getOrderItems(int orderId);
}
