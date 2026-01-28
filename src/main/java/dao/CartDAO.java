package dao;

import java.util.List;

import model.Cart;

public interface CartDAO {
	boolean addToCart(int userId, int productId);
	List<Cart> getCartByUser(int userId);
	boolean removeFromCart(int cartId);
}
