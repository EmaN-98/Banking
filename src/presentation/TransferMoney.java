package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataAccess.AccountDAL;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferMoney extends JFrame {

	private JPanel contentPane;
	//private JFrame frame;
	private JTextField txtAccountID;
	private JTextField txtAccountID2;
	private JTextField txtAmount;
	static TransferMoney frame;

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TransferMoney();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TransferMoney() {
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
		
		JLabel lblTransferMoney = new JLabel("TransferMoney");
		lblTransferMoney.setForeground(Color.WHITE);
		lblTransferMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransferMoney.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
	
		panel.add(lblTransferMoney);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int accountId1=Integer.parseInt(txtAccountID.getText());
					int accountId2=Integer.parseInt(txtAccountID2.getText());
					double amount=Double.parseDouble(txtAmount.getText());
					AccountDAL.moneyBetweenAccounts(accountId1,accountId2,amount);
					JOptionPane.showMessageDialog(null, "Money successfully transfered");
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot transfer money");
				}
			}
		});
		btnTransfer.setForeground(new Color(153, 0, 51));
		btnTransfer.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTransfer.setBounds(410, 240, 164, 35);
		panel_1.add(btnTransfer);
		
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
		txtAccountID.setBounds(210, 24, 314, 27);
		panel_1.add(txtAccountID);
		txtAccountID.setColumns(10);
		
		txtAccountID2 = new JTextField();
		txtAccountID2.setColumns(10);
		txtAccountID2.setBounds(210, 62, 314, 27);
		panel_1.add(txtAccountID2);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(210, 100, 314, 27);
		panel_1.add(txtAmount);
		
		JLabel lblFrom = new JLabel("From AccountID:");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setForeground(new Color(153, 0, 51));
		lblFrom.setFont(new Font("Arial", Font.BOLD, 20));
		lblFrom.setBounds(26, 17, 164, 35);
		panel_1.add(lblFrom);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setForeground(new Color(153, 0, 51));
		lblAmount.setFont(new Font("Arial", Font.BOLD, 20));
		lblAmount.setBounds(36, 93, 119, 35);
		panel_1.add(lblAmount);
		
		JLabel lblToClientid = new JLabel("To AccountID:");
		lblToClientid.setHorizontalAlignment(SwingConstants.CENTER);
		lblToClientid.setForeground(new Color(153, 0, 51));
		lblToClientid.setFont(new Font("Arial", Font.BOLD, 20));
		lblToClientid.setBounds(26, 55, 151, 35);
		panel_1.add(lblToClientid);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
