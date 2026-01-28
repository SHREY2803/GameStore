package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/gamestore_project_db";
	private static final String USER = "root";
	private static final String PASSWORD = "SK@kul280302";
	
	// This method gives DB connection 
	public static Connection getConnection() {

        Connection connection = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(
                    URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
