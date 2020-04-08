package dataAccess;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


import dbConnection.ConnectionMake;

import model.Report;
import model.User;

public class EmployeesDAL {

	private static Connection conn;
	private final static String insertUser = "INSERT INTO user (userId,name,email,username,password)" + " VALUES (?,?,?,?,?)";
	private final static String deleteUser = "DELETE FROM user WHERE userId = ? ";
	private final static String editUser = "UPDATE user SET name=?, email=?, username=?, password=? WHERE userId= ? ";
	private final static String findStatementString = "SELECT * FROM user where userId = ?";
	//private final static String findStatementStringName = "SELECT * FROM user where name = ?";
	private final static String findActivity = "SELECT * FROM report where date between ? and ? and employeeId = ?";
	
	
	public static int insertEmployee(User e) {
	
		String fileName="";
		try {										
			fileName = "keepIDuser.txt";

			FileWriter fileWriter = 
		            new FileWriter(fileName);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
			bufferedWriter.write(User.count);
			bufferedWriter.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		
		PreparedStatement stmt = null;
		ResultSet res;
		
		int userId=1;
		try {
			conn = ConnectionMake.getConnection();
			userId=e.getUserId();
			String name=e.getName();
			String email=e.getEmail();
			String username=e.getUsername();
			String password=e.getPassword();
			
			stmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, userId);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

			//ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM user\r\n");
			//JTable table = new JTable(buildTableModel(rs));
			//JOptionPane.showMessageDialog(null, new JScrollPane(table));

		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert Emplyee. Try another ID");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}

		return userId;
	}

	public static void deleteEmployee(int id) {
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteUser, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

		/*	ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM User\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));*/

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete Employee.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static User editEmployee(User user) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editUser, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());

			stmt.setInt(5, user.getUserId());
			int changes =stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

			/*ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM User\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));*/
		

            if(changes > 0) { 
            	System.out.println(changes);
                return user;
            } else {
                return null;
            }

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Sorry, cannot edit Employee. Check again the Id, name, email, username and password desired");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return null;
	}

	
	 public static List<User> findAll() {
	        
	        List<User> users = new ArrayList<>();
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                User user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));

//
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
	 
	 public static User findById(int userId) {
	        
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findStatementString);
	            preparedStatement.setInt(1, userId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                User user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(4));

	                return user;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	 
	 public static User findByName(String name) {
	        
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findStatementString);
	            preparedStatement.setString(1, name);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                User user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(4));

	                return user;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	 
	 public boolean createReport(int employeeId, String nameEmployee, String activity, int date) {
	       
	        try {
	        	Connection conn=ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO report (employeeId, nameEmployee, activity, date) VALUES(?,?,?,?)",
	                    Statement.RETURN_GENERATED_KEYS);



	            preparedStatement.setInt(1, employeeId);
	            preparedStatement.setString(2, nameEmployee);
	            preparedStatement.setString(3, activity);
	            preparedStatement.setInt(4, date);


	            preparedStatement.execute();
	            ResultSet resultSet = preparedStatement.getGeneratedKeys();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 public static List<Report> generateReport(int employeeId, String date1, String date2) {
	        
		 List<Report> reports = new ArrayList<>();
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findActivity);
	            preparedStatement.setInt(3, employeeId);
	            preparedStatement.setString(1, date1);
	            preparedStatement.setString(2, date2);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Report report = new Report(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
	                reports.add(report);
	                return reports;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
}
