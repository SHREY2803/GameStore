package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import model.Order;
import model.OrderItem;
import util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

	// 1️. Create order (orders table)
	@Override
	public int createOrder(Connection con, Order order) {
		// TODO Auto-generated method stub
		int orderId = 0;

		String query = "INSERT INTO orders(user_id, total_amount, status) VALUES (?, ?, ?)";

		/*
		 * In Java Database Connectivity (JDBC), ps.getGeneratedKeys() is a method call
		 * on a PreparedStatement object (ps) used to retrieve the auto-generated keys
		 * (such as auto-incremented primary keys) that were created as a result of
		 * executing an INSERT statement.
		 */

		/*
		 * For that to happen, you must first inform the JDBC driver that you intend to
		 * retrieve generated keys when creating the PreparedStatement. This is
		 * typically done by passing the Statement.RETURN_GENERATED_KEYS constant to the
		 * Connection.prepareStatement() method.
		 */
		try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, order.getUserId());
			ps.setDouble(2, order.getTotalAmount());
			ps.setString(3, order.getStatus());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				orderId = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderId;
	}

	// 2️. Insert order items
	@Override
	public void addOrderItems(Connection con, int orderId, List<OrderItem> items) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO order_items(order_id, product_id, price, quantity) VALUES (?, ?, ?, ?)";

		/*
		 * Why we used executeBatch()? One order can have many items
		 * 
		 * Batch insert is faster
		 * 
		 * Cleaner JDBC design
		 */

		try (PreparedStatement ps = con.prepareStatement(query)) {

			for (OrderItem item : items) {
				ps.setInt(1, orderId);
				ps.setInt(2, item.getProductId());
				ps.setDouble(3, item.getPrice());
				ps.setInt(4, item.getQuantity());
				ps.addBatch();
			}
			ps.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Order> getOrdersByUser(int userId) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<>();
		String query = "SELECT * FROM orders WHERE user_id = ? ORDER BY order_date DESC";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				o.setUserId(rs.getInt("user_id"));
				o.setOrderDate(rs.getTimestamp("order_date"));
				o.setTotalAmount(rs.getDouble("total_amount"));
				o.setStatus(rs.getString("status"));
				orders.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;

	}

	@Override
	public List<OrderItem> getOrderItems(int orderId) {
		// TODO Auto-generated method stub
		List<OrderItem> items = new ArrayList<>();

		String query = """
				    SELECT oi.*, p.name, p.image_url
				    FROM order_items oi
				    JOIN products p ON oi.product_id = p.id
				    WHERE oi.order_id = ?
				""";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderItem item = new OrderItem();
				item.setId(rs.getInt("id"));
				item.setOrderId(rs.getInt("order_id"));
				item.setProductId(rs.getInt("product_id"));
				item.setPrice(rs.getDouble("price"));
				item.setQuantity(rs.getInt("quantity"));
				item.setProductName(rs.getString("name"));
				item.setImageUrl(rs.getString("image_url"));
				items.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public void updateOrderStatus(int orderId, String status) {
		// TODO Auto-generated method stub
		String sql = "UPDATE orders SET status = ? WHERE id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, status);
			ps.setInt(2, orderId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public double getOrderAmount(int orderId) {
		double amount = 0;
		String sql = "SELECT total_amount FROM orders WHERE id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				amount = rs.getDouble("total_amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}

}
