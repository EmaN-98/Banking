package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.AccountBLL;
import businessLogic.ClientBLL;
import model.Account;
import model.Client;

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

public class EmployeeView extends JFrame {

	private JPanel contentPane;
	//private JFrame frame;
	static EmployeeView frame;
	private JTextField textIDc;
	private JTextField textIDa;

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EmployeeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmployeeView() {
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
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));

		panel.add(lblEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(0, 75, 584, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsertclient = new JButton("InsertClient");
		btnInsertclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertClient i=new InsertClient();
				i.NewScreen();
			}
		});
		btnInsertclient.setForeground(new Color(153, 0, 51));
		btnInsertclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertclient.setBounds(10, 11, 150, 35);
		panel_1.add(btnInsertclient);
		
		JButton btnEditclient = new JButton("EditClient");
		btnEditclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditClient c=new EditClient();
				c.NewScreen();
			}
		});
		btnEditclient.setForeground(new Color(153, 0, 51));
		btnEditclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditclient.setBounds(10, 57, 150, 35);
		panel_1.add(btnEditclient);
		
		JButton btnDeleteclient = new JButton("DeleteClient");
		btnDeleteclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteClient d=new DeleteClient();
				d.NewScreen();
			}
		});
		btnDeleteclient.setForeground(new Color(153, 0, 51));
		btnDeleteclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteclient.setBounds(10, 101, 150, 35);
		panel_1.add(btnDeleteclient);
		
		JButton btnViewClient = new JButton("ViewClients");
		btnViewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.util.List<Client> c=new ArrayList<Client>();
					c=ClientBLL.viewAllClients();
					JOptionPane.showMessageDialog(null, "Clients:"+c.toString());
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot show clients informations");
				}
			}
		});
		btnViewClient.setForeground(new Color(153, 0, 51));
		btnViewClient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewClient.setBounds(10, 147, 150, 35);
		panel_1.add(btnViewClient);
		
		JButton btnTransfermoney = new JButton("TransferMoney");
		btnTransfermoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferMoney t=new TransferMoney();
				t.NewScreen();
			}
		});
		btnTransfermoney.setForeground(new Color(153, 0, 51));
		btnTransfermoney.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTransfermoney.setBounds(133, 239, 194, 35);
		panel_1.add(btnTransfermoney);
		
		JButton btnPayutilitiesbills = new JButton("ProcessUtilitiesBills");
		btnPayutilitiesbills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessUtilitiesBills p=new ProcessUtilitiesBills();
				p.NewScreen();
			}
		});
		btnPayutilitiesbills.setForeground(new Color(153, 0, 51));
		btnPayutilitiesbills.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPayutilitiesbills.setBounds(355, 239, 219, 35);
		panel_1.add(btnPayutilitiesbills);
		
		JButton btnInsertaccount = new JButton("InsertAccount");
		btnInsertaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertAccount i=new InsertAccount();
				i.NewScreen();
			}
		});
		btnInsertaccount.setForeground(new Color(153, 0, 51));
		btnInsertaccount.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertaccount.setBounds(399, 11, 175, 35);
		panel_1.add(btnInsertaccount);
		
		JButton btnEditaccount = new JButton("EditAccount");
		btnEditaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAccount c=new EditAccount();
				c.NewScreen();
			}
		});
		btnEditaccount.setForeground(new Color(153, 0, 51));
		btnEditaccount.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditaccount.setBounds(399, 57, 175, 35);
		panel_1.add(btnEditaccount);
		
		JButton btnDeleteaccount = new JButton("DeleteAccount");
		btnDeleteaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAccount d=new DeleteAccount();
				d.NewScreen();
			}
		});
		btnDeleteaccount.setForeground(new Color(153, 0, 51));
		btnDeleteaccount.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteaccount.setBounds(399, 101, 175, 35);
		panel_1.add(btnDeleteaccount);
		
		JButton btnViewAccounts = new JButton("ViewAccounts");
		btnViewAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.util.List<Account> c=new ArrayList<Account>();
					c=AccountBLL.viewAllAccounts();
					JOptionPane.showMessageDialog(null, "Accounts:"+c.toString());
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot show accounts informations");
				}
			}
		});
		btnViewAccounts.setForeground(new Color(153, 0, 51));
		btnViewAccounts.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewAccounts.setBounds(399, 147, 175, 35);
		panel_1.add(btnViewAccounts);
		
		JButton button = new JButton("Back");
		
		button.setForeground(new Color(153, 0, 51));
		button.setFont(new Font("Arial", Font.PLAIN, 20));
		button.setBounds(10, 239, 98, 35);
		panel_1.add(button);
		
		JButton btnView1client = new JButton("View1Client");
		btnView1client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textIDc.getText());
				try {
					Client c=new Client();
					c=ClientBLL.viewClient(id);
					JOptionPane.showMessageDialog(null, "Client:"+c.toString());
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot show client informations");
				}
			}
		});
		btnView1client.setForeground(new Color(153, 0, 51));
		btnView1client.setFont(new Font("Arial", Font.PLAIN, 20));
		btnView1client.setBounds(97, 193, 150, 35);
		panel_1.add(btnView1client);
		
		JButton btnViewcaccount = new JButton("View1Account");
		btnViewcaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textIDa.getText());
				try {
					Account a=new Account();
					a=AccountBLL.viewAccount(id);
					JOptionPane.showMessageDialog(null, "Account:"+a.toString());
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot show account informations");
				}
			}
		});
		btnViewcaccount.setForeground(new Color(153, 0, 51));
		btnViewcaccount.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewcaccount.setBounds(399, 193, 175, 35);
		panel_1.add(btnViewcaccount);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblId.setBounds(10, 200, 33, 20);
		panel_1.add(lblId);
		
		JLabel label = new JLabel("ID:");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(306, 200, 33, 28);
		panel_1.add(label);
		
		textIDc = new JTextField();
		textIDc.setBounds(41, 201, 53, 20);
		panel_1.add(textIDc);
		textIDc.setColumns(10);
		
		textIDa = new JTextField();
		textIDa.setColumns(10);
		textIDa.setBounds(336, 203, 53, 20);
		panel_1.add(textIDa);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
