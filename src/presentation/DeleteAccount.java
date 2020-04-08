package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.AccountBLL;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAccount extends JFrame {

	private JPanel contentPane;
//	private JFrame frame;
	private JTextField txtAccountID;
	static DeleteAccount frame;

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteAccount() {
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
		
		JLabel lblEmployee = new JLabel("DeleteAccount");
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
		
		JButton btnDeleteclient = new JButton("DeleteAccount");
		btnDeleteclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(txtAccountID.getText());
				try {
				AccountBLL.deleteAccount(id);
				JOptionPane.showMessageDialog(null, "Account successfully deleted.");
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot delete account.");

				} 
			}
		});
		btnDeleteclient.setForeground(new Color(153, 0, 51));
		btnDeleteclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteclient.setBounds(410, 240, 164, 35);
		panel_1.add(btnDeleteclient);
		
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
		
		txtAccountID = new JTextField();
		txtAccountID.setBounds(211, 65, 314, 27);
		panel_1.add(txtAccountID);
		txtAccountID.setColumns(10);
		
		JLabel lblAccountId = new JLabel("Account ID:");
		lblAccountId.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountId.setForeground(new Color(153, 0, 51));
		lblAccountId.setFont(new Font("Arial", Font.BOLD, 20));
		lblAccountId.setBounds(62, 58, 119, 35);
		panel_1.add(lblAccountId);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
