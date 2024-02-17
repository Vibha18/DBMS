import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class ADDRESS {
	
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";

	private JFrame frmAddress;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame frame;
	public String s_id;
	public String state;
	public String address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDRESS window = new ADDRESS();
					window.frmAddress.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ADDRESS() {
		frame=new JFrame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddress = new JFrame();
		frmAddress.getContentPane().setBackground(new Color(230, 230, 250));
		frmAddress.setTitle("ADDRESS");
		frmAddress.setBounds(100, 100, 1345, 752);
		frmAddress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddress.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SOLDIER ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(170, 196, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADDRESS INFORMATION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_1.setBounds(422, 47, 506, 40);
		frmAddress.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STATE");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(170, 431, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ADDRESS");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(170, 310, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField.setBounds(636, 196, 377, 40);
		frmAddress.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField_1.setBounds(636, 297, 377, 47);
		frmAddress.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField_2.setBounds(636, 418, 377, 47);
		frmAddress.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(142, 150, 927, 421);
		frmAddress.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 btnNewButton.setForeground(new Color(0, 128, 0));
		 btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				s_id= textField.getText();
				state= textField_1.getText();
				address=textField_2.getText();
				
				System.out.println(s_id);
	    		System.out.println(state);
	    		System.out.println(address);
	    		
	    		 if(s_id== null ||s_id.trim().length() == 0 || state== null
							|| state.trim().length() == 0 || address==null || address.trim().length()==0) {
	    			 JOptionPane.showMessageDialog(null,
								"Please Enter all the Fields");
	    		 }
	    		 else{
	    		try
	    		{
	    				Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="insert into ADDRESS values(?,?,?)";
	    				PreparedStatement preparedStmt =connection.prepareStatement(query);
	    				preparedStmt.setString(1, s_id);
	    				
	    				preparedStmt.setString(2, address);
	    				preparedStmt.setString(3, state);
	    				preparedStmt.execute();
	    				
	    				System.out.println("Inserted Successfully");
	    				//Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
						connection.close();
						
	    		}
	    		catch(Exception e7)
	    		{
	    			e7.printStackTrace();
	    		}
	    		     textField.setText(null);
	    			 textField_1.setText(null);
					 textField_2.setText(null);
			 
	    	 }
				
			}
		});
		 btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 25));
		 btnNewButton.setBounds(36, 178, 120, 36);
		panel.add(btnNewButton);
		
		
		btnNewButton.setBounds(553, 356, 111, 39);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1 .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(742, 359, 119, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(20, 27, 86, 21);
		frmAddress.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(1117, 359, 142, 31);
		frmAddress.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Delete & Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADDR2.main(new String[] {});
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton_3.setBounds(1117, 297, 234, 40);
		frmAddress.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWA.main(new String[] {});
			}
		});
		btnNewButton_5.setForeground(Color.BLUE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(1117, 418, 124, 31);
		frmAddress.getContentPane().add(btnNewButton_5);
	}
}
