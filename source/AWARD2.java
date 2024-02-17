import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AWARD2 extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";

	public String sd_id;
	public String award_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AWARD2 frame = new AWARD2();
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
	public AWARD2() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AWARDS ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(679, 37, 568, 40);
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
		panel.setBounds(380, 263, 817, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(53, 66, 261, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AWARD NAME");
		lblNewLabel_2.setBounds(52, 189, 217, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(330, 307, 153, 39);
		panel.add(btnReset);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
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
		    				String query="Update awards set sd_id='"+textField.getText()+"', award_name='"+textField_1.getText()+"' where sd_id='"+textField.getText()+"'  ";
		    				PreparedStatement preparedStmt =connection.prepareStatement(query);
		    				
		    				preparedStmt.execute();
		    				
		    				System.out.println("Updated Successfully");
		    				//Search_CB.addItem(R_Name);
							JOptionPane.showMessageDialog(null, "Data Updated Successfully");
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
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(620, 307, 153, 39);
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
		btnNewButton_4_1.setBounds(1229, 171, 142, 31);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AWARDS.main(new String[] {});
			}
		});
		//Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(50, 24, 80, 31);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(679, 166, 119, 36);
		contentPane.add(btnNewButton_1_2);
	}
}