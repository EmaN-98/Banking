package businessLogic;

import dataAccess.Login;

public class LoginBLL {
	
	public static boolean login(String username, String password) {

		return Login.login(username,password);
	}

}
