package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.EmployeesBLL;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteEmployee extends JFrame {

	private JPanel contentPane;
//	private JFrame frame;
	private JTextField txtEmployeeId;
	static DeleteEmployee frame;
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteEmployee() {
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
		
		JLabel lblEmployee = new JLabel("DeleteEmployee");
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
		
		JButton btnDeleteclient = new JButton("DeleteEmployee");
		btnDeleteclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(txtEmployeeId.getText());
				try {
				EmployeesBLL.deleteEmployee(id);
				JOptionPane.showMessageDialog(null, "Employee successfully deleted.");
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot delete employee.");

				} 
			}
		});
		btnDeleteclient.setForeground(new Color(153, 0, 51));
		btnDeleteclient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteclient.setBounds(380, 240, 194, 35);
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
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(210, 60, 314, 27);
		panel_1.add(txtEmployeeId);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeId.setForeground(new Color(153, 0, 51));
		lblEmployeeId.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmployeeId.setBounds(30, 53, 148, 35);
		panel_1.add(lblEmployeeId);
		
		
		
		
		
		this.setLocationRelativeTo(null);
	}
}
