package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Client {

	private int clientId;
	private String name;
	private String ICN;
	private String PNC;
	private String address;
	private String email;


	public static int countC;
	
	public Client(String name, String ICN, String PNC, String address, String email) {
		//super();
		String fileName="";
		try {																																								//private final static String findStatementString = "SELECT * FROM product where id_p = ?";
			fileName = "keepIDclient.txt";

			FileReader fileReader = 
		            new FileReader(fileName);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			countC=bufferedReader.read();
			System.out.println("***"+countC+"***");
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
		int clientId=countC++;
		this.clientId = clientId;
		this.name=name;
		this.ICN = ICN;
		this.PNC = PNC;
		this.address = address;
		this.email = email;
		
	}

	
	public Client(int clientId, String name, String iCN, String pNC, String address, String email) {
		super();
		this.clientId = clientId;
		this.name = name;
		ICN = iCN;
		PNC = pNC;
		this.address = address;
		this.email = email;
	}


	public Client() {
		
	}


	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getICN() {
		return ICN;
	}
	public void setICN(String iCN) {
		ICN = iCN;
	}
	public String getPNC() {
		return PNC;
	}
	public void setPNC(String pNC) {
		PNC = pNC;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", ICN=" + ICN + ", PNC=" + PNC + ", address="
				+ address + ", email=" + email + "]" + "\n";
	}
	
	/*public static void main(String[] args) {
		Client c1=new Client("name","123446789","987456252","Cluj-Napoca","name@yahoo.com");
		System.out.println(c1);
		Client c2=new Client("name2","123446789","987456252","Cluj-Napoca","name@yahoo.com");
		System.out.println(c2);
	}*/


	
}
