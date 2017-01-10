package prototype2;

import java.awt.CardLayout;
import java.sql.*;

public class DatabaseConnection {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public DatabaseConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://cs2s:3306/sebmackin", "seb.mackin", "pugilism boggy");
			statement = connection.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	public void getUsers() {
		try {
			String query = "select * from users";
			resultSet = statement.executeQuery(query);
			System.out.println("Records");

			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String id = resultSet.getString("userid");

				System.out.println("Username: " + username + " password: " + password + " userID: " + id + "");
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	public void addUser(String userInput, String passwordInput) {
		try {
			// Code below until println courtesy of mkyong, April 5, 2011
			// http://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/

			String insertTableSQL = "INSERT INTO users" + "(username, password) VALUES" + "(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, userInput);
			preparedStatement.setString(2, passwordInput);

			preparedStatement.executeUpdate();

			System.out.println("User registered");

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	public void loginUser(String userInput, String passwordInput) {
		try {
			String checkTableSQL = "SELECT username, password FROM users WHERE username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(checkTableSQL);
			preparedStatement.setString(1, userInput);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String dbuser = resultSet.getString("username");
				String dbpass = resultSet.getString("password");

				if (dbuser.equals(userInput) && dbpass.equals(passwordInput)) {
					// if exists then log in
					System.out.println("user exists");
				}
			}
		}

		catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
}
