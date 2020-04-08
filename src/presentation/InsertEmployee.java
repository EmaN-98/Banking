package presentation;
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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InsertEmployee extends JFrame {

	private JPanel contentPane;
	//private JFrame frame;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtEmail;
	static InsertEmployee frame;

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InsertEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsertEmployee() {
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
		
		JLabel lblEmployee = new JLabel("InsertEmployee");
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
		//lblLogin.setBackground(Color.WHITE);
		panel.add(lblEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsertclient = new JButton("InsertEmployee");
		btnInsertclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String username = txtUsername.getText();				
				String password = txtPassword.getText();
				String email = txtEmail.getText();
				
		
				boolean ok1=false,ok2=false,ok3=false;
				try {
					 
					//Client c1=new Client();//(name,ICN,PNC,address,email);
					if(Pattern.matches("[a-zA-Z]+" ,name)&&!name.isEmpty()) {
						ok1=true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Check again name!");
					}
					
					if (Pattern.matches("[a-zA-Z0-9]+",username) && !username.isEmpty() ) {
			           
			            ok2=true;
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null, "Check again username!");
			            ok2=false;
			        }
					if(Pattern.matches("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)" ,email)&&!email.isEmpty()) {
						ok3=true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Check again email!");
					}
					if(ok3&&ok1&&ok2) {
						User u1=new User(name,email,username,password);
						EmployeesBLL.insertEmployee(u1);
					JOptionPane.showMessageDialog(null, "Employee successfully added.");}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot add employee.");
				}
			}
		});
		btnInsertclient.setForeground(new Color(153, 0, 51));
		btnInsertclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertclient.setBounds(392, 240, 182, 35);
		panel_1.add(btnInsertclient);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setForeground(new Color(153, 0, 51));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setBounds(10, 240, 110, 35);
		panel_1.add(btnBack);
		
		txtName = new JTextField();
		txtName.setBounds(210, 24, 314, 27);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(210, 98, 314, 27);
		panel_1.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(210, 136, 314, 27);
		panel_1.add(txtPassword);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(210, 60, 314, 27);
		panel_1.add(txtEmail);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(153, 0, 51));
		lblName.setFont(new Font("Arial", Font.BOLD, 20));
		lblName.setBounds(42, 17, 119, 35);
		panel_1.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(153, 0, 51));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
		lblUsername.setBounds(42, 91, 119, 35);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(153, 0, 51));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblPassword.setBounds(42, 129, 119, 35);
		panel_1.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(153, 0, 51));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(42, 53, 119, 35);
		panel_1.add(lblEmail);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
