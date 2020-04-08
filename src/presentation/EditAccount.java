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
import java.awt.event.ActionEvent;

public class EditAccount extends JFrame {

	private JPanel contentPane;
	//private JFrame frame;
	private JTextField txtType;
	private JTextField txtAmount;
	private JTextField txtCreateDate;
	static EditAccount frame;
	private JTextField txtID;

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EditAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditAccount() {
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
		
		JLabel lblEmployee = new JLabel("EditAccount");
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
		
		panel.add(lblEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEditAccount = new JButton("EditAccount");
		btnEditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = txtType.getText();
				Double amount = Double.parseDouble(txtAmount.getText());				
				String createDate = txtCreateDate.getText();
			
				int id=Integer.parseInt(txtID.getText());
		
				try {
					Account a1=new Account(id,type,amount,createDate);
					Account a2=new Account();
					a2=AccountBLL.editAccount(a1);
		
					JOptionPane.showMessageDialog(null, "Account successfully updated.");
					JOptionPane.showMessageDialog(null, "Edited to:"+a2.toString());
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot update Account.");
				}
			}
		});
		btnEditAccount.setForeground(new Color(153, 0, 51));
		btnEditAccount.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditAccount.setBounds(410, 240, 164, 35);
		panel_1.add(btnEditAccount);
		
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
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(153, 0, 51));
		lblId.setFont(new Font("Arial", Font.BOLD, 20));
		lblId.setBounds(42, 139, 119, 35);
		panel_1.add(lblId);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(210, 138, 314, 27);
		panel_1.add(txtID);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
