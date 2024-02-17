import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
public class REGI2 extends JFrame {
	
	String url="jdbc:mysql://localhost/army";
	String user="root";
	String password="root@123";
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public String reg_name;
	public String center;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGI2 frame = new REGI2();
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
	public REGI2() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGIMENT ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(635, 43, 568, 40);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(348, 255, 817, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("REG NAME");
		lblNewLabel_1.setBounds(45, 61, 245, 40);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("CENTRE");
		lblNewLabel_2.setBounds(48, 180, 168, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		textField = new JTextField();
		textField.setBounds(366, 62, 294, 40);
		panel.add(textField);
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(366, 168, 294, 39);
		panel.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				reg_name= textField.getText();
				System.out.println(reg_name);
				
				try
	    		{
	    			Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="Delete from regiment where reg_name='"+textField.getText()+"'  ";
	    				PreparedStatement preparedStmt =connection.prepareStatement(query);
	    				preparedStmt.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
						connection.close();
						preparedStmt.close();
	    		}
	    		catch(Exception e71)
	    		{
	    			e71.printStackTrace();
	    		}
	    			 
	    			 textField.setText(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(63, 313, 153, 39);
		panel.add(btnNewButton_2);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(338, 313, 153, 39);
		panel.add(btnReset);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				reg_name= textField.getText();
				center= textField_1.getText();
				
				System.out.println(reg_name);
	    		System.out.println(center);
	    		
	    		 if(reg_name== null || reg_name.trim().length() == 0 || center== null
							|| center.trim().length() == 0 ) {
	    			 JOptionPane.showMessageDialog(null,
								"Please Enter all the Fields");
	    		 }
	    		 else{
	    		try
	    		{
	    			Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="Update regiment set reg_name='"+textField.getText()+"', center='"+textField_1.getText()+"' where reg_name='"+textField.getText()+"'  ";
	    				PreparedStatement preparedStmt =connection.prepareStatement(query);
	    				preparedStmt.execute();
						JOptionPane.showMessageDialog(null, "Data Updated Successfully");
						connection.close();
						preparedStmt.close();
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

		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(592, 313, 153, 39);
		panel.add(btnUpdate);
		
		JButton btnNewButton_4_1 = new JButton("Log Out");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4_1.setForeground(new Color(220, 20, 60));
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4_1.setBounds(1212, 145, 142, 31);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				REGIMENT.main(new String[] {});
			}
		});
		//Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(49, 43, 81, 31);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(635, 154, 119, 36);
		contentPane.add(btnNewButton_1_2);
	}
}