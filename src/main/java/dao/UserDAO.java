package dao;

import model.User;

public interface UserDAO {

    // Register new user
    boolean registerUser(User user);

    // Login user
    User login(String email, String password);

    // Check if email already exists
    boolean isEmailExists(String email);
}
