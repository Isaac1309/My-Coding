import java.sql.*;

public class Main {
    public static void main(String[] args)  throws SQLException {
		dataList();
		insertData("hello from Java", "Charles");
		updateData("Hello from Java", "Java", 3);
		dataList();
		deleteData(3);
		dataList();
	}
	
	static void dataList() throws SQLException{
        Connection connection = DriverManager.getConnection(
         "jdbc:mysql://localhost//messages_db?serverTimezome=UTC",
         "root", "1234"
        );
		
		String sql = "SELECT * FROM message";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {			
			int id = rs.getInt("id_message");
			String message = rs.getString("message");
			String author = rs.getString("author");
			String dates = rs.getString("dates");
			
			System.out.printf("%d %s %s %s\n", id, message,author,dates);
		}
		
		rs.close();
		ps.close();
		connection.close();
	}
	
	static void insertData(String message, String author) throws SQLException{
		Connection connection = DriverManager.getConnection(
         "jdbc:mysql://localhost//messages_db?serverTimezome=UTC",
         "root", "1234"
        );
		
		String sql = "INSERT INTO message(message,author,dates) VALUES (?,?, CURRENT_TIME())";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, message);
		ps.setString(2, author);
		ps.executeUpdate();
		
		ps.close();
		connection.close();
	}

	static void updateData(String message, String author, int id) throws SQLException{
		Connection connection = DriverManager.getConnection(
         "jdbc:mysql://localhost//messages_db?serverTimezome=UTC",
         "root", "1234"
        );
		
		String sql = "UPDATE messages SET message=?, author=? WHERE id_message = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, message);
		ps.setString(2, author);
		ps.setInt(3, id);
		ps.executeUpdate();
		
		ps.close();
		connection.close();
	}

	static void deleteData(int id) throws SQLException{
        Connection connection = DriverManager.getConnection(
         "jdbc:mysql://localhost//messages_db?serverTimezome=UTC",
         "root", "1234"
        );
		
		String sql = "DELETE FROM messages WHERE id_message = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
		ps.close();
		connection.close();
	}
}
