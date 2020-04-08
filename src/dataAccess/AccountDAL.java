package dataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


import dbConnection.ConnectionMake;
import model.Account;

public class AccountDAL {

	private static Connection conn;
	private final static String insertAccount = "INSERT INTO account (accountId,type,amount,createDate)" + " VALUES (?,?,?,?)";
	private final static String deleteAccount = "DELETE FROM account WHERE accountId = ? ";
	private final static String editAccount = "UPDATE account SET type=?, amount=?, createDate=? WHERE accountId= ? ";
	private final static String findStatementString = "SELECT * FROM account where accountId = ?";
	public static int nrBill=1;
	
	public static int insertAccount(Account a) {
	
		String fileName="";
		try {										
			fileName = "keepIDaccount.txt";

			FileWriter fileWriter = 
		            new FileWriter(fileName);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
			bufferedWriter.write(Account.countA);
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
		
		int accountId=1;
		try {
			conn = ConnectionMake.getConnection();
			accountId=a.getAccountId();
			String name=a.getType();
			Double amount=a.getAmount();
			String createDate=a.getCreateDate();
			
			stmt = conn.prepareStatement(insertAccount, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, accountId);
			stmt.setString(2, name);
			stmt.setDouble(3, amount);
			stmt.setString(4, createDate);
			
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

			//ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM account\r\n");
			//JTable table = new JTable(buildTableModel(rs));
			//JOptionPane.showMessageDialog(null, new JScrollPane(table));

		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert account. Try another ID");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}

		return accountId;
	}

	public static void deleteAccount(int id) {
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteAccount, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

		/*	ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM Account\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));*/

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete Account.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static Account editAccount(Account account) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editAccount, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, account.getType());
			stmt.setDouble(2, account.getAmount());
			stmt.setString(3, account.getCreateDate());
			stmt.setInt(4, account.getAccountId());
			int changes =stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

			/*ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM Account\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));*/
		

            if(changes > 0) { 
            	System.out.println(changes);
                return account;
            } else {
                return null;
            }

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Sorry, cannot edit Account. Check again the Id, name, ICN, PNC, address and email desired");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return null;
	}

	
	 public static List<Account> findAll() {
	        
	        List<Account> accounts = new ArrayList<>();
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM account");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Account account = new Account(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4));

//
	                accounts.add(account);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return accounts;
	    }
	 
	 public static Account findById(int accountId) {
	        
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findStatementString);
	            preparedStatement.setInt(1, accountId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                Account account = new Account(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4));

	                return account;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
	 
	 public static void moneyBetweenAccounts(int id1, int id2, double amount) {

			Account account1=new Account();
			Account account2=new Account();
			account1=findById(id1);
			account2=findById(id2);
			
			double amount1=account1.getAmount();
			double amount2=account2.getAmount();
			
			if(amount>amount1) JOptionPane.showMessageDialog(null, "Sorry, cannot transfer money. Insufficient funds");
			else {
				account1.setAmount(amount1-amount);
				account2.setAmount(amount2+amount);
				editAccount(account1);
				editAccount(account2);
			}
		}
	 
	 public static void processUtilitiesBills(int idAccount,int idUtility,double amount,String utilityName) {
		 
		 moneyBetweenAccounts(idAccount,idUtility,amount);
		 
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate localDate = LocalDate.now();
         String date = dtf.format(localDate);
         String fileName="";
         try {																																								//private final static String findStatementString = "SELECT * FROM product where id_p = ?";
 			fileName = "processUtilityBills.txt";

 			FileWriter fileWriter = 
		            new FileWriter(fileName);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
			bufferedWriter.write("Process Utility Bill no. "+nrBill+"\n");
			bufferedWriter.append("Client:"+idAccount+"\n");
			bufferedWriter.append("Bill:"+utilityName+" account:"+idUtility+"\n");
			bufferedWriter.append("Amount:"+amount+"\n");
			bufferedWriter.append(date);
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
	

			
		}
	 
}
