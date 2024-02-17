import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;
public class FAMILY extends JFrame {
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";

private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

public String sol_id;
public String name;
public String relationship;
public String ph_no;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAMILY frame = new FAMILY();
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
	public FAMILY() {
		frame=new JFrame();
		setTitle("FAMILY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 646);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FAMILY INFORMATION");
		lblNewLabel.setBounds(530, 47, 445, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(85, 132, 856, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sol_id= textField.getText();
				name= textField_1.getText();
				relationship= textField_2.getText();
				ph_no = textField_3.getText();
				
				System.out.println(sol_id);
	    		System.out.println(name);
	    		System.out.println(relationship);
	    		System.out.println(ph_no);
	    		
	    		 if(sol_id== null || sol_id.trim().length() == 0 || name== null
							|| name.trim().length() == 0  || relationship== null || relationship.trim().length() == 0 || ph_no== null || ph_no.trim().length() == 0 ){
	    			 JOptionPane.showMessageDialog(null,
								"Please Enter all the Fields");
	    		 }
	    		 else{
	    		try
	    		{
	    			Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="insert into FAMILY values(?,?,?,?)";
	    				PreparedStatement preparedStmt =connection.prepareStatement(query);
	    				preparedStmt.setString(1, sol_id);
	    				preparedStmt.setString(2, name );
	    				preparedStmt.setString(3, relationship);
	    				preparedStmt.setString(4, ph_no);
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

		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnNewButton.setBounds(555, 351, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnNewButton_1.setBounds(695, 351, 121, 23);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(555, 23, 275, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(555, 83, 275, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(555, 152, 275, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(555, 231, 275, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(81, 13, 207, 42);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(81, 83, 148, 30);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_3 = new JLabel("RELATIONSHIP");
		lblNewLabel_3.setBounds(81, 162, 194, 30);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_4 = new JLabel("PHN NO");
		lblNewLabel_4.setBounds(81, 231, 201, 30);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnNewButton_3 = new JButton("DELETE & UPDATE");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FAM2.main(new String[] {});
			}
		});
		btnNewButton_3.setBounds(966, 172, 229, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LOG OUT");
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4.setBounds(966, 258, 144, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		btnNewButton_2.setBounds(38, 47, 128, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWF.main(new String[] {});
			}
		});
		btnNewButton_5.setBounds(966, 337, 85, 21);
		contentPane.add(btnNewButton_5);
		
		
		
		
		
		
		
	}
}