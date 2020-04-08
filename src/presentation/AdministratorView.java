package presentation;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.EmployeesBLL;

import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AdministratorView extends JFrame {

	private JPanel contentPane;
//	private JFrame frame;
	static AdministratorView frame;
	private JTextField textField;

	
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AdministratorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdministratorView() {
		initialize();
	}
	

	private void initialize() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 584, 75);
		contentPane.add(panel);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setForeground(Color.WHITE);
		lblAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrator.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
		//lblLogin.setBackground(Color.WHITE);
		panel.add(lblAdministrator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsertEmployee = new JButton("InsertEmployee");
		btnInsertEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertEmployee i=new InsertEmployee();
				i.NewScreen();
			}
		});
		btnInsertEmployee.setForeground(new Color(153, 0, 51));
		btnInsertEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertEmployee.setBounds(10, 11, 182, 35);
		panel_1.add(btnInsertEmployee);
		
		JButton btnEditEmployee = new JButton("EditEmployee");
		btnEditEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditEmployee c=new EditEmployee();
				c.NewScreen();
			}
		});
		btnEditEmployee.setForeground(new Color(153, 0, 51));
		btnEditEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditEmployee.setBounds(115, 57, 182, 35);
		panel_1.add(btnEditEmployee);
		
		JButton btnDeleteEmployee = new JButton("DeleteEmployee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployee d=new DeleteEmployee();
				d.NewScreen();
			}
		});
		btnDeleteEmployee.setForeground(new Color(153, 0, 51));
		btnDeleteEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteEmployee.setBounds(201, 103, 182, 35);
		panel_1.add(btnDeleteEmployee);
		
		JButton btnViewEmployee = new JButton("ViewEmployees");
		btnViewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.util.List<User> u=new ArrayList<User>();
					u=EmployeesBLL.viewAllEmployees();
					JOptionPane.showMessageDialog(null, "Employees:"+u.toString());
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot show employees informations");
				}
				
			}
		});
		btnViewEmployee.setForeground(new Color(153, 0, 51));
		btnViewEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewEmployee.setBounds(298, 149, 182, 35);
		panel_1.add(btnViewEmployee);
		
		JButton btnTransfermoney = new JButton("Generate Report");
		btnTransfermoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportView r=new ReportView();
				r.NewScreen();
				
			}
		});
		btnTransfermoney.setForeground(new Color(153, 0, 51));
		btnTransfermoney.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTransfermoney.setBounds(172, 240, 240, 35);
		panel_1.add(btnTransfermoney);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(frame==null) System.out.println("frame null");
				frame.setVisible(false);
			}
		});
		btnBack.setForeground(new Color(153, 0, 51));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setBounds(10, 240, 98, 35);
		panel_1.add(btnBack);
		
		JButton btnView1Employee = new JButton("View1Employee");
		btnView1Employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				try {
					User u=new User();
					u=EmployeesBLL.viewEmployee(id);
					JOptionPane.showMessageDialog(null, "Employee:"+u.toString());
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot show employee informations");
				}
				
			}
		});
		btnView1Employee.setForeground(new Color(153, 0, 51));
		btnView1Employee.setFont(new Font("Arial", Font.PLAIN, 20));
		btnView1Employee.setBounds(392, 194, 182, 35);
		panel_1.add(btnView1Employee);
		
		textField = new JTextField();
		textField.setBounds(328, 195, 55, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(285, 195, 33, 27);
		panel_1.add(lblNewLabel);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
