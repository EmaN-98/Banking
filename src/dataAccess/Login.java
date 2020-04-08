package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnection.ConnectionMake;


public class Login {
	
	private static Connection conn;
	private final static String findStatementString = "SELECT * FROM user where username = ? and password = ?";
	
	 public static boolean login(String username, String password) {
	        
		 boolean toReturn = false;
			conn = ConnectionMake.getConnection();
			//Connection dbConnection = ConnectionMake.getConnection();
			PreparedStatement findStatement = null;
			ResultSet rs = null;
			try {
				findStatement = conn.prepareStatement(findStatementString);
				findStatement.setString(1, username);
				findStatement.setString(2, password);
				rs = findStatement.executeQuery();
				rs.next();
				int userId=rs.getInt("userId");
				String name = rs.getString("name");
				String email = rs.getString("email");
				if(rs!=null)
					toReturn =true;
				//System.out.println(userId+" "+name);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionMake.close(rs);
				ConnectionMake.close(findStatement);
				ConnectionMake.close(conn);
			}
			return toReturn;
	
	 }
}
