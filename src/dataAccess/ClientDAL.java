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
import java.util.Vector;
import javax.swing.JOptionPane;


import dbConnection.ConnectionMake;

import model.Client;

public class ClientDAL {

	private static Connection conn;
	private final static String insertClient = "INSERT INTO client (clientId,name,ICN,PNC,address,email)" + " VALUES (?,?,?,?,?,?)";
	private final static String deleteClient = "DELETE FROM client WHERE clientId = ? ";
	private final static String editClient = "UPDATE client SET name=?, ICN=?, PNC=?, address=?, email=? WHERE clientId= ? ";
	private final static String findStatementString = "SELECT * FROM client where clientId = ?";

	public static int insertClient(Client c) {
	
		String fileName="";
		try {										
			fileName = "keepIDclient.txt";

			FileWriter fileWriter = 
		            new FileWriter(fileName);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
			bufferedWriter.write(Client.countC);
			bufferedWriter.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		PreparedStatement stmt = null;
		ResultSet res;
		
		int clientId = 0;
		try {
			conn = ConnectionMake.getConnection();
			clientId=c.getClientId();
			String name=c.getName();
			String ICN=c.getICN();
			String PNC=c.getPNC();
			String address=c.getAddress();
			String email=c.getEmail();
			stmt = conn.prepareStatement(insertClient, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, clientId);
			stmt.setString(2, name);
			stmt.setString(3, ICN);
			stmt.setString(4, PNC);
			stmt.setString(5, address);
			stmt.setString(6, email);
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

			//ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM client\r\n");
			//JTable table = new JTable(buildTableModel(rs));
			//JOptionPane.showMessageDialog(null, new JScrollPane(table));
//EmployeesDAL.createReport();
		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert client. Try another ID");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}

		return clientId;
	}

	public static void deleteClient(int id) {
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteClient, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

		/*	ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM client\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));*/

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete client.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static Client editClient(Client client) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editClient, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getICN());
			stmt.setString(3, client.getPNC());
			stmt.setString(4, client.getAddress());
			stmt.setString(5, client.getEmail());
			stmt.setInt(6, client.getClientId());
			int changes =stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

			/*ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM client\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));*/
		

            if(changes > 0) { 
            	System.out.println(changes);
                return client;
            } else {
                return null;
            }

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Sorry, cannot edit client. Check again the Id, name, ICN, PNC, address and email desired");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return null;
	}

	
	 public static List<Client> findAll() {
	        
	        List<Client> clients = new ArrayList<>();
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM client");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Client client = new Client(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

	               // client.setName(resultSet.getString(2));
	              //  client.setICN(resultSet.getString(3));
	               // client.setPNC(resultSet.getString(4));
	              //  client.setAddress(resultSet.getString(5));
	               // client.setEmail(resultSet.getString(6));
//
	                clients.add(client);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return clients;
	    }
	 
	 public static Client findById(int clientId) {
	        
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findStatementString);
	            preparedStatement.setInt(1, clientId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                Client client = new Client(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));

	                return client;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
}
