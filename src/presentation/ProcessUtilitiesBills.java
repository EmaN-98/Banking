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

public class ProcessUtilitiesBills extends JFrame {

	private JPanel contentPane;
//	private JFrame frame;
	private JTextField txtAccountID;
	private JTextField txtUtilityID;
	private JTextField txtAmount;
	private JTextField txtUtilityName;
	static ProcessUtilitiesBills frame;

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ProcessUtilitiesBills();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProcessUtilitiesBills() {
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
		
		JLabel lblProcessUtilitiesBills = new JLabel("ProcessUtilitiesBills");
		lblProcessUtilitiesBills.setForeground(Color.WHITE);
		lblProcessUtilitiesBills.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProcessUtilitiesBills.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
	
		panel.add(lblProcessUtilitiesBills);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idAccount=Integer.parseInt(txtAccountID.getText());
				int idUtility=Integer.parseInt(txtUtilityID.getText());
				double amount=Double.parseDouble(txtAmount.getText());
				String utilityName=txtUtilityName.getText();
					try{
						AccountBLL.processUtilitiesBills(idAccount, idUtility, amount, utilityName);
						JOptionPane.showMessageDialog(null, "Utilities bill successfully processed.");
					}catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Sorry, could not process utilities bill");
					}
			}
		});
		btnPay.setForeground(new Color(153, 0, 51));
		btnPay.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPay.setBounds(410, 240, 164, 35);
		panel_1.add(btnPay);
		
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
		
		txtUtilityID = new JTextField();
		txtUtilityID.setColumns(10);
		txtUtilityID.setBounds(210, 62, 314, 27);
		panel_1.add(txtUtilityID);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(210, 100, 314, 27);
		panel_1.add(txtAmount);
		
		JLabel lblFrom = new JLabel("From AccountID:");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setForeground(new Color(153, 0, 51));
		lblFrom.setFont(new Font("Arial", Font.BOLD, 20));
		lblFrom.setBounds(26, 25, 174, 27);
		panel_1.add(lblFrom);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setForeground(new Color(153, 0, 51));
		lblAmount.setFont(new Font("Arial", Font.BOLD, 20));
		lblAmount.setBounds(36, 101, 119, 27);
		panel_1.add(lblAmount);
		
		JLabel lblUtilityID = new JLabel("To UtilityID:");
		lblUtilityID.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilityID.setForeground(new Color(153, 0, 51));
		lblUtilityID.setFont(new Font("Arial", Font.BOLD, 20));
		lblUtilityID.setBounds(26, 63, 151, 27);
		panel_1.add(lblUtilityID);
		
		JLabel lblUtilityName = new JLabel("Utility Name");
		lblUtilityName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilityName.setForeground(new Color(153, 0, 51));
		lblUtilityName.setFont(new Font("Arial", Font.BOLD, 20));
		lblUtilityName.setBounds(46, 139, 119, 27);
		panel_1.add(lblUtilityName);
		
		txtUtilityName = new JTextField();
		txtUtilityName.setColumns(10);
		txtUtilityName.setBounds(210, 138, 314, 27);
		panel_1.add(txtUtilityName);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
