package daoimpl;

import dao.CardDAO;
import model.Card;

public class CardDAOImpl implements CardDAO {

	@Override
	public Card validateCard(int userId, String cardNumber, String cardHolder, String expiryMonth, String expiryYear,
			String cvv) {
		 String sql = """
		            SELECT id, balance
		            FROM cards
		            WHERE user_id = ?
		              AND card_number = ?
		              AND card_holder = ?
		              AND expiry_month = ?
		              AND expiry_year = ?
		              AND cvv = ?
		        """;
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deductBalance(int cardId, double amount) {
		// TODO Auto-generated method stub
		
	}

}
