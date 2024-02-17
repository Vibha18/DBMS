import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class WEAP2 {
	private JFrame frame;
	private JFrame frmAddress;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";
	public String sr_id;
	public String wp_id;
	public String wp_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WEAP2 window = new WEAP2();
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
	public WEAP2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frmAddress = new JFrame();
		frmAddress.getContentPane().setBackground(new Color(255, 182, 193));
		frmAddress.setTitle("ADDRESS");
		frmAddress.setBounds(100, 100, 1345, 752);
		frmAddress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddress.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WEAPON ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_1.setBounds(626, 34, 506, 40);
		frmAddress.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(292, 255, 927, 421);
		frmAddress.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("WEAPON NAME");
		lblNewLabel_2.setBounds(34, 223, 261, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_3 = new JLabel("WEAPON ID");
		lblNewLabel_3.setBounds(34, 131, 261, 40);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("SOLDIER ID");
		lblNewLabel.setBounds(34, 33, 261, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		textField_1 = new JTextField();
		textField_1.setBounds(433, 128, 377, 47);
		panel.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(433, 34, 377, 40);
		panel.add(textField);
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(433, 220, 377, 47);
		panel.add(textField_2);
		textField_2.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField_2.setColumns(10);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(81, 337, 153, 39);
		panel.add(btnReset);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sr_id= textField.getText();
				wp_id= textField_1.getText();
				wp_name= textField_2.getText();
				
				System.out.println(sr_id);
	    		System.out.println(wp_id);
	    		System.out.println(wp_name);
	    		
	    		 if(sr_id== null || sr_id.trim().length() == 0 || wp_id== null
							|| wp_id.trim().length() == 0||wp_name== null || wp_name.trim().length() == 0 ) {
	    			 JOptionPane.showMessageDialog(null,
								"Please Enter all the Fields");
	    		 }
	    		 else{
	    		try
	    		{
	    			Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="Update weapon set sr_id='"+textField.getText()+"',wp_id='"+textField_1.getText()+"',wp_name='"+textField_2.getText()+"' where sr_id='"+textField.getText()+"' ";
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
					 textField_2.setText(null);
	    	 }
				
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(719, 337, 153, 39);
		panel.add(btnUpdate);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(1179, 137, 142, 31);
		frmAddress.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WEAPON.main(new String[] {});
			}
		});
		//Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(27, 34, 72, 31);
		frmAddress.getContentPane().add(btnNewButton_1_3);
		
		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(627, 136, 119, 36);
		frmAddress.getContentPane().add(btnNewButton_1_2);
	}
}