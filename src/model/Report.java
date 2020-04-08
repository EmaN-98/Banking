package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Report {
	
	private int reportId;
	private int employeeId;
	private String nameEmployee;
	private String activity;
	private String date;
	
public static int countR;
	
	public Report(int employeeId, String nameEmployee,String activity, String date ) {
		//super();
		String fileName="";
		try {																																								//private final static String findStatementString = "SELECT * FROM product where id_p = ?";
			fileName = "keepIDreport.txt";

			FileReader fileReader = 
		            new FileReader(fileName);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			countR=bufferedReader.read();
			System.out.println("***"+countR+"***");
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
		int reportId=countR++;
		this.reportId = reportId;
		this.employeeId = employeeId;
		this.nameEmployee = nameEmployee;
		this.activity = activity;
		this.date = date;
		
	}

	public Report(int reportId, int employeeId, String nameEmployee, String activity, String date) {
		super();
		this.reportId = reportId;
		this.employeeId = employeeId;
		this.nameEmployee = nameEmployee;
		this.activity = activity;
		this.date = date;
	}

	public Report() {
		super();
	}
	
	

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", employeeId=" + employeeId + ", nameEmployee=" + nameEmployee
				+ ", activity=" + activity + ", date=" + date + "]\n";
	}
	
	
	
	

}
