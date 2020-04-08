package businessLogic;

import java.util.ArrayList;
import java.util.List;


import businessLogic.EmailValidator;
import businessLogic.Validator;

import dataAccess.ClientDAL;

import model.Client;

public class ClientBLL { 

	private static List<Validator<Client>> validators;

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
	}

	

	public static List<Client> viewAllClients() {

		return ClientDAL.findAll();
	}
	
	public static Client viewClient(int id) {

		return ClientDAL.findById(id);
	}
	
	public static int insertClient(Client client) {
		
		return ClientDAL.insertClient(client);
	}

	public static Client editClient(Client client) {

		 return ClientDAL.editClient(client);
	}

	public static void deleteClient(int id) {

		ClientDAL.deleteClient(id);
	}
	
	
	
}
