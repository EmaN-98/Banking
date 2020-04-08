	
	package presentation;

	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

import businessLogic.EmployeesBLL;

import model.Report;

import java.awt.Color;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

	public class ReportView extends JFrame {
//id,name,activity,date
		private JPanel contentPane;
	//	private JFrame frame;
		private JTextField txtID;
		static ReportView frame;
		private JTextField txtDate1;
		private JTextField txtDate2;

		
		public static void NewScreen() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new ReportView();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public ReportView() {
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
			
			JLabel lblProcessUtilitiesBills = new JLabel("Generate Report");
			lblProcessUtilitiesBills.setForeground(Color.WHITE);
			lblProcessUtilitiesBills.setHorizontalAlignment(SwingConstants.RIGHT);
			lblProcessUtilitiesBills.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
	
			panel.add(lblProcessUtilitiesBills);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 228, 196));
			panel_1.setBounds(0, 75, 584, 286);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JButton btnEditclient = new JButton("Generate Report");
			btnEditclient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int id=Integer.parseInt(txtID.getText());
						String date1=txtDate1.getText();
						String date2=txtDate2.getText();
						List<Report> reports = new ArrayList<>();
							reports=EmployeesBLL.generateReport(id, date1, date2);
							JOptionPane.showMessageDialog(null, "Report for employee: "+reports.toString());
						}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			btnEditclient.setForeground(new Color(153, 0, 51));
			btnEditclient.setFont(new Font("Arial", Font.PLAIN, 20));
			btnEditclient.setBounds(371, 240, 203, 35);
			panel_1.add(btnEditclient);
			
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
			txtID.setBounds(210, 65, 314, 27);
			panel_1.add(txtID);
			txtID.setColumns(10);
			
			JLabel lblEmplyeeID = new JLabel("Employee ID:");
			lblEmplyeeID.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmplyeeID.setForeground(new Color(153, 0, 51));
			lblEmplyeeID.setFont(new Font("Arial", Font.BOLD, 20));
			lblEmplyeeID.setBounds(24, 65, 151, 27);
			panel_1.add(lblEmplyeeID);
			
			JLabel lblFromDate = new JLabel("From date:");
			lblFromDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblFromDate.setForeground(new Color(153, 0, 51));
			lblFromDate.setFont(new Font("Arial", Font.BOLD, 20));
			lblFromDate.setBounds(24, 117, 151, 27);
			panel_1.add(lblFromDate);
			
			JLabel lblToDate = new JLabel("To date:");
			lblToDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblToDate.setForeground(new Color(153, 0, 51));
			lblToDate.setFont(new Font("Arial", Font.BOLD, 20));
			lblToDate.setBounds(24, 167, 151, 27);
			panel_1.add(lblToDate);
			
			txtDate1 = new JTextField();
			txtDate1.setColumns(10);
			txtDate1.setBounds(210, 117, 314, 27);
			panel_1.add(txtDate1);
			
			txtDate2 = new JTextField();
			txtDate2.setColumns(10);
			txtDate2.setBounds(210, 167, 314, 27);
			panel_1.add(txtDate2);
			
			
			
			
			
			this.setLocationRelativeTo(null);
		}
	}
