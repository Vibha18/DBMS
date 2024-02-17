import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
public class AWARDS extends JFrame {
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame frame;
	public String sd_id;
	public String award_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AWARDS frame = new AWARDS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AWARDS() {
		frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AWARDS INFORMATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(429, 108, 568, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		textField.setBounds(679, 321, 294, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		textField_1.setBounds(679, 447, 294, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(222, 260, 817, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
			sd_id= textField.getText();
				award_name= textField_1.getText();
				
				System.out.println(sd_id);
	    		System.out.println(award_name);
	    		
	    		 if(sd_id== null || sd_id.trim().length() == 0 || award_name== null
							|| award_name.trim().length() == 0 ) {
	    			 JOptionPane.showMessageDialog(null,
								"Please Enter all the Fields");
	    		 }
	    		 else{
	    		try
	    		{
	    			Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="insert into AWARDS values(?,?)";
	    				PreparedStatement preparedStmt =connection.prepareStatement(query);
	    				preparedStmt.setString(1, sd_id);
	    				preparedStmt.setString(2, award_name);
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
			 
	    	 }
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(418, 317, 141, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(656, 317, 122, 40);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(53, 66, 261, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AWARD NAME");
		lblNewLabel_2.setBounds(52, 189, 217, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBounds(33, 29, 106, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Log Out");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4_1.setForeground(new Color(220, 20, 60));
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4_1.setBounds(1078, 401, 142, 31);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_3 = new JButton("Delete & Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AWARD2.main(new String[] {});
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton_3.setBounds(1078, 330, 234, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWAW.main(new String[] {});
			}
		});
		btnNewButton_5.setBounds(1078, 460, 121, 31);
		contentPane.add(btnNewButton_5);
	}
}
