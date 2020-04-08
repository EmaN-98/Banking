package businessLogic;


import java.util.List;


import dataAccess.AccountDAL;

import model.Account;


public class AccountBLL { 

	

	public static List<Account> viewAllAccounts() {

		return AccountDAL.findAll();
	}
	
	public static Account viewAccount(int id) {

		return AccountDAL.findById(id);
	}
	
	public static int insertAccount(Account account) {

		return AccountDAL.insertAccount(account);
	}

	public static Account editAccount(Account account) {

		 return AccountDAL.editAccount(account);
	}

	public static void deleteAccount(int id) {

		AccountDAL.deleteAccount(id);
	}
	
	public static void moneyBetweenAccounts(int id1, int id2, double amount) {

		AccountDAL.moneyBetweenAccounts(id1,id2,amount);
	}
	
	
	public static void processUtilitiesBills(int idAccount, int idUtility, double amount, String utilityName) {

		AccountDAL.processUtilitiesBills(idAccount,idUtility,amount,utilityName);
	}
	
	


	
}
