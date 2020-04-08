package presentation;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.AccountBLL;
import businessLogic.ClientBLL;
import businessLogic.LoginBLL;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteClient extends JFrame {

	private JPanel contentPane;
	//private JFrame frame;
	private JTextField txtID;
	static DeleteClient frame ;

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteClient() {
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
		
		JLabel lblEmployee = new JLabel("DeleteClient");
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
		
		JButton btnInsertclient = new JButton("DeleteClient");
		btnInsertclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=Integer.parseInt(txtID.getText());
				try {
				ClientBLL.deleteClient(id);
				JOptionPane.showMessageDialog(null, "Client successfully deleted.");
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot delete client.");

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
		
		txtID = new JTextField();
		txtID.setBounds(209, 71, 314, 27);
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblclientId = new JLabel("ID client:");
		lblclientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientId.setForeground(new Color(153, 0, 51));
		lblclientId.setFont(new Font("Arial", Font.BOLD, 20));
		lblclientId.setBounds(47, 71, 119, 27);
		panel_1.add(lblclientId);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
