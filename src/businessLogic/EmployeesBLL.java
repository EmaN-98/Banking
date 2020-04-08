package businessLogic;


import java.util.List;

import dataAccess.EmployeesDAL;
import model.Report;
import model.User;




public class EmployeesBLL { 

	

	public static List<User> viewAllEmployees() {

		return EmployeesDAL.findAll();
	}
	
	public static User viewEmployee(int id) {

		return EmployeesDAL.findById(id);
	}
	
	public static int insertEmployee(User employee) {

		return EmployeesDAL.insertEmployee(employee);
	}

	public static User editEmployee(User employee) {

		 return EmployeesDAL.editEmployee(employee);
	}

	public static void deleteEmployee(int id) {

		EmployeesDAL.deleteEmployee(id);
	}
	
	public static List<Report> generateReport(int id,String date1, String date2) {
		
		return EmployeesDAL.generateReport(id,date1,date2);
	}
	


	
}
