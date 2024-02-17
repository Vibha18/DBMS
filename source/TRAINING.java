import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.*;
import java.sql.*;

public class TRAINING extends JFrame {
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";
	
	private JFrame frame;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public String so_id;
	public String type;
	public String r_name;
	public String duration;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRAINING frame = new TRAINING();
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
	public TRAINING() {
		frame=new JFrame();
		setTitle("TRAINING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRAINING INFORMATION");
		lblNewLabel.setBounds(435, 60, 433, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(271, 197, 753, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				so_id= textField.getText();
				type= textField_1.getText();
				r_name= textField_2.getText();
				duration = textField_3.getText();
				
				System.out.println(so_id);
	    		System.out.println(type);
	    		System.out.println(r_name);
	    		System.out.println(duration);
	    		
	    		 if(so_id== null || so_id.trim().length() == 0 || type== null
							|| type.trim().length() == 0  || r_name== null || r_name.trim().length() == 0 || duration== null || duration.trim().length() == 0 ){
	    			 JOptionPane.showMessageDialog(null,
								"Please Enter all the Fields");
	    		 }
	    		 else{
	    		try
	    		{
	    			Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="insert into TRAINING values(?,?,?,?)";
	    				PreparedStatement preparedStmt =connection.prepareStatement(query);
	    				preparedStmt.setString(1, so_id);
	    				preparedStmt.setString(2, type);
	    				preparedStmt.setString(3, r_name);
	    				preparedStmt.setString(4, duration);
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
					 textField_3.setText(null);
					 
	    	 }
				
			}
		});

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(361, 383, 141, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(567, 383, 122, 40);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
	
			}
		});

		
		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(52, 76, 184, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("TYPE");
		lblNewLabel_2.setBounds(52, 147, 184, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_3 = new JLabel("REGIMENT NAME");
		lblNewLabel_3.setBounds(52, 223, 243, 23);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_4 = new JLabel("DURATION");
		lblNewLabel_4.setBounds(52, 294, 200, 23);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		textField_3 = new JTextField();
		textField_3.setBounds(320, 290, 238, 30);
		panel.add(textField_3);
		textField_3.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(320, 219, 238, 30);
		panel.add(textField_2);
		textField_2.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(320, 143, 238, 30);
		panel.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(320, 72, 238, 30);
		panel.add(textField);
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField.setColumns(10);
		
		

		JButton btnNewButton_3 = new JButton("Delete & Update");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TRAIN2.main(new String[] {});
			}
		});
		btnNewButton_3.setBounds(1067, 254, 234, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4_1 = new JButton("BACK");
		btnNewButton_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_4_1.setBounds(10, 10, 106, 25);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(1078, 347, 142, 31);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWT.main(new String[] {});
			}
		});
		btnNewButton_5.setBounds(1078, 413, 121, 31);
		contentPane.add(btnNewButton_5);
	}
}