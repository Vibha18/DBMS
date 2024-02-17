import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.*;

public class PERSONAL extends JFrame {
	

	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	//JComboBox<String>comboBox;
	public String soldier_id ; 
	public String s_name;
	public String gender;
	public String dob;
	public String blood_group;
	public String date_of_join;
	public String regi_name;
	
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PERSONAL frame = new PERSONAL();
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
	public PERSONAL() {
		frame=new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(0,0,1780 , 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setTitle("PERSONAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1327, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERSONAL INFORMATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(384, 35, 450, 56);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 11, 89, 31);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(218, 114, 796, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SOLDIER  ID");
		lblNewLabel_1.setBounds(65, 48, 188, 31);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(65, 115, 188, 24);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GENDER");
		lblNewLabel_3.setBounds(65, 178, 188, 31);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel("DATE OF BIRTH");
		lblNewLabel_4.setBounds(65, 238, 188, 31);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("BLOOD GROUP");
		lblNewLabel_5.setBounds(65, 307, 188, 31);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("REGI NAME");
		lblNewLabel_7.setBounds(65, 442, 188, 24);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("DATE OF JOIN");
		lblNewLabel_6.setBounds(65, 378, 188, 24);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		textField.setBounds(346, 50, 303, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		textField_1.setBounds(346, 114, 303, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(346, 178, 303, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		textField_3.setBounds(346, 240, 303, 31);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textField_4.setBounds(346, 307, 309, 31);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textField_5.setBounds(346, 377, 303, 31);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textField_6.setBounds(346, 441, 303, 31);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		//JComboBox comboBox = new JComboBox<String>();
		//comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male","Female"}));
		//comboBox.setBounds(346, 180, 303, 31);
		//panel.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(488, 514, 109, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.out.println("Connecting to DATABASE");
				 soldier_id=textField.getText();
				 s_name=textField_1.getText();
				 gender=textField_2.getText();
				 dob=textField_3.getText();
				 blood_group=textField_4.getText();
				 date_of_join=textField_5.getText();
				 regi_name=textField_6.getText();
				 //gender=comboBox.getItemAt(comboBox.getSelectedIndex());
				 System.out.println(soldier_id );
				 System.out.println(s_name);
				 System.out.println(gender);
				 System.out.println(dob);
				 System.out.println(blood_group);
				 System.out.println(date_of_join);
				 System.out.println(regi_name);
				 
		 if(soldier_id ==null ||soldier_id.trim().length()==0 ||  s_name==null || s_name.trim().length()==0  ||gender==null  || 
				gender.trim().length()==0		||	 dob==null ||dob.trim().length()==0|| blood_group==null ||blood_group.trim().length()==0|| date_of_join==null ||
						date_of_join.trim().length()==0|| regi_name==null ||  regi_name.trim().length()==0) {
					 JOptionPane.showMessageDialog(null,"Please Enter all the fields");
				 }
		 else
				 {
					 try {
						 Connection connection=DriverManager.getConnection(url,user,password);
						 System.out.println("Connected to database");
						 String query="insert into PERSONAL values(?,?,?,?,?,?,?)";
						 PreparedStatement preparedStmt=connection.prepareStatement(query);
						 preparedStmt.setString(1,soldier_id);
						 preparedStmt.setString(2,s_name);
						 preparedStmt.setString(3,gender);
						 preparedStmt.setString(4,dob);
						 preparedStmt.setString(5,blood_group);
						 preparedStmt.setString(6,date_of_join);
						 preparedStmt.setString(7,regi_name);
						 preparedStmt.execute();
						 System.out.println("Inserted successfully");
						 JOptionPane.showMessageDialog(null,"Data inserted successfully");
						 connection.close();
					 }
					 catch(Exception e7)
					 {
						 e7.printStackTrace();
					 }
					 textField.setText(null);
					 textField_1.setText(null);
					 textField_3.setText(null);
					 textField_4.setText(null);
					 textField_5.setText(null);
					 textField_6.setText(null);
					 textField_2.setText(null);
					
					 
					 
				 }
			}
			
		});
		panel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(639, 514, 126, 31);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				//textField_8.setText(null);
				//comboBox.setSelectedItem(null);
			}
		});
		
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("Delete & Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PERS2.main(new String[] {});
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton_3.setBounds(1079, 280, 234, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.setBounds(1079, 365, 142, 31);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWP.main(new String[] {});
			}
		});
		btnNewButton_5.setBounds(1079, 421, 121, 31);
		contentPane.add(btnNewButton_5);
	}
}