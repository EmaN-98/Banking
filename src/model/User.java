package model;
import java.io.*;


public class User {
	
	public int userId;
	private String name;
	public String email;
	public String username;
    private String password;
    
    public static int count;
    
	public User(String name, String email, String username, String password) {
		//super();
		String fileName="";
		try {																																								//private final static String findStatementString = "SELECT * FROM product where id_p = ?";
			fileName = "keepIDuser.txt";

			FileReader fileReader = 
		            new FileReader(fileName);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			count=bufferedReader.read();
			System.out.println("***"+count+"***");
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
		int UuserId=count++;
		this.userId = UuserId;
		this.name=name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	

	public User(int userId, String name, String email, String username, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	

	public User() {
		super();
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		userId=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		User.count = count;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", username=" + username
				+ ", password=" + password + "]\n";
	}

	

	

}
