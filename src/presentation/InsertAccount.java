package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.AccountBLL;
import model.Account;

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

public class InsertAccount extends JFrame {

	private JPanel contentPane;
//	private JFrame frame;
	private JTextField txtType;
	private JTextField txtAmount;
	private JTextField txtCreateDate;
	static InsertAccount frame;

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InsertAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsertAccount() {
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
		
		JLabel lblEmployee = new JLabel("InsertAccount");
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
	
		panel.add(lblEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsertclient = new JButton("InsertAccount");
		btnInsertclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtType.getText();
				String txt2 = txtAmount.getText();
				String txt3 = txtCreateDate.getText();

				
					boolean ok1=false,ok2=false,ok3=false;
					try {
						 
						//Client c1=new Client();//(name,ICN,PNC,address,email);
						if(Pattern.matches("[a-zA-Z]+" ,txt)&&!txt.isEmpty()) {
							ok1=true;
						}
						else {
							JOptionPane.showMessageDialog(null, "Check again type!");
						}
						
						if (Pattern.matches("\\d+\\.\\d+",txt2) && !txt2.isEmpty() ) {
				           
				            ok2=true;
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null, "Check again amount!");
				            ok2=false;
				        }
						if (Pattern.matches("^\\d?\\d.\\d{2}.\\d{4}$",txt3) && !txt3.isEmpty()) {
				        
				            ok3 = true;

				        }else
				        {
				        	JOptionPane.showMessageDialog(null, "Check again createDate!");
				            ok3=false;
				        }
						if(ok3&&ok1&&ok2) {
							double amount=Double.parseDouble(txt2);
							Account a2=new Account(txt,amount,txt3);
						AccountBLL.insertAccount(a2);
						JOptionPane.showMessageDialog(null, "Account successfully added.");}
					//Account a1=new Account(txt,amount,txt3);
					//AccountBLL.insertAccount(a1);
					//JOptionPane.showMessageDialog(null, "Account successfully added.");
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot add account.");
				}
			}
		});
		btnInsertclient.setForeground(new Color(153, 0, 51));
		btnInsertclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertclient.setBounds(410, 240, 164, 35);
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
		
		txtType = new JTextField();
		txtType.setBounds(210, 24, 314, 27);
		panel_1.add(txtType);
		txtType.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(210, 62, 314, 27);
		panel_1.add(txtAmount);
		
		txtCreateDate = new JTextField();
		txtCreateDate.setColumns(10);
		txtCreateDate.setBounds(210, 100, 314, 27);
		panel_1.add(txtCreateDate);
		
		JLabel lblType = new JLabel("Type");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setForeground(new Color(153, 0, 51));
		lblType.setFont(new Font("Arial", Font.BOLD, 20));
		lblType.setBounds(42, 17, 119, 35);
		panel_1.add(lblType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setForeground(new Color(153, 0, 51));
		lblAmount.setFont(new Font("Arial", Font.BOLD, 20));
		lblAmount.setBounds(42, 54, 119, 35);
		panel_1.add(lblAmount);
		
		JLabel lblCreateDate = new JLabel("Create Date");
		lblCreateDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateDate.setForeground(new Color(153, 0, 51));
		lblCreateDate.setFont(new Font("Arial", Font.BOLD, 20));
		lblCreateDate.setBounds(42, 93, 119, 35);
		panel_1.add(lblCreateDate);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
