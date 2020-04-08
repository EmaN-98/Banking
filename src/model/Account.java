package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Account {

	private int accountId;
	private String type;
	private double amount;
	private String createDate;
//	private String ownerICN;
	
	public static int countA;
	
	public Account(String type, double amount, String createDate) {
		//super();
		String fileName="";
		try {																																								//private final static String findStatementString = "SELECT * FROM product where id_p = ?";
			fileName = "keepIDaccount.txt";

			FileReader fileReader = 
		            new FileReader(fileName);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			countA=bufferedReader.read();
			System.out.println("***"+countA+"***");
			bufferedReader.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int accountId=countA++;
		this.accountId = accountId;
		this.type=type;
		this.amount = amount;
		this.createDate = createDate;
		//this.ownerICN = ownerICN;
		
	}
	
	public Account(int accountId, String type, double amount, String createDate) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.amount = amount;
		this.createDate = createDate;
		//this.ownerICN = ownerICN;
	}
	

	public Account() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", type=" + type + ", amount=" + amount + ", createDate="
				+ createDate + "]\n";
	}
	/*
	public static void main(String[] args) {
	Account c1=new Account("lei",1253.0,"12.02.2020");
	System.out.println(c1);
	
}*/

	
}