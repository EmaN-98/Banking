package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.ClientBLL;
import model.Client;

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

public class InsertClient extends JFrame {

	private JPanel contentPane;
//	private JFrame frame;
	private JTextField txtName;
	private JTextField txtICN;
	private JTextField txtPNC;
	private JTextField txtAddress;
	private JTextField txtEmail;
	static InsertClient frame;


	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InsertClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsertClient() {
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
		
		JLabel lblEmployee = new JLabel("InsertClient");
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
				String name = txtName.getText();
				String ICN = txtICN.getText();
				String PNC = txtPNC.getText();
				String address = txtAddress.getText();
				String email = txtEmail.getText();
		boolean ok1=false,ok2=false,ok3=false,ok4=false;
				try {
					 
					//Client c1=new Client();//(name,ICN,PNC,address,email);
					if(Pattern.matches("[a-zA-Z]+" ,name)&&!name.isEmpty()) {
						ok1=true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Check again name!");
					}
					if(Pattern.matches("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)" ,email)&&!email.isEmpty()) {
						ok2=true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Check again email!");
					}
					if (Pattern.matches("[a-zA-Z0-9]+",ICN) && !ICN.isEmpty() ) {
			           
			            ok3=true;
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null, "Check again ICN!");
			            ok3=false;
			        }
					if (Pattern.matches("[0-9]+",PNC) && !PNC.isEmpty()) {
			        
			            ok4 = true;

			        }else
			        {
			        	JOptionPane.showMessageDialog(null, "Check again PNC!");
			            ok4=false;
			        }
					if(ok4&&ok3&&ok1&&ok2) {Client c2=new Client(name,ICN,PNC,address,email);
					ClientBLL.insertClient(c2);
					JOptionPane.showMessageDialog(null, "Client successfully added.");}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot add client.");
				}
			}
		});
		btnInsertclient.setForeground(new Color(153, 0, 51));
		btnInsertclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertclient.setBounds(424, 240, 150, 35);
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
		
		txtICN = new JTextField();
		txtICN.setColumns(10);
		txtICN.setBounds(210, 62, 314, 27);
		panel_1.add(txtICN);
		
		txtPNC = new JTextField();
		txtPNC.setColumns(10);
		txtPNC.setBounds(210, 100, 314, 27);
		panel_1.add(txtPNC);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(210, 138, 314, 27);
		panel_1.add(txtAddress);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(210, 177, 314, 27);
		panel_1.add(txtEmail);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(153, 0, 51));
		lblName.setFont(new Font("Arial", Font.BOLD, 20));
		lblName.setBounds(42, 17, 119, 35);
		panel_1.add(lblName);
		
		JLabel lblIcn = new JLabel("ICN");
		lblIcn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcn.setForeground(new Color(153, 0, 51));
		lblIcn.setFont(new Font("Arial", Font.BOLD, 20));
		lblIcn.setBounds(42, 54, 119, 35);
		panel_1.add(lblIcn);
		
		JLabel lblPnc = new JLabel("PNC");
		lblPnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnc.setForeground(new Color(153, 0, 51));
		lblPnc.setFont(new Font("Arial", Font.BOLD, 20));
		lblPnc.setBounds(42, 93, 119, 35);
		panel_1.add(lblPnc);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(new Color(153, 0, 51));
		lblAddress.setFont(new Font("Arial", Font.BOLD, 20));
		lblAddress.setBounds(42, 131, 119, 35);
		panel_1.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(153, 0, 51));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(42, 170, 119, 35);
		panel_1.add(lblEmail);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
