import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ADDR2 {
	private JFrame frame;
	private JFrame frmAddress;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String url="jdbc:mysql://localhost/army";
	String user="root";
	String password="root@123";
	
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
					ADDR2 window = new ADDR2();
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
	public ADDR2() {
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
		
		JLabel lblNewLabel_1 = new JLabel("ADDRESS ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_1.setBounds(731, 37, 506, 40);
		frmAddress.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(289, 239, 927, 421);
		frmAddress.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(119, 361, 119, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("UPDATE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Connecting to DATABASE");
				s_id= textField.getText();
				state= textField_1.getText();
				address= textField_2.getText();
				
				System.out.println(s_id);
	    		System.out.println(state);
	    		System.out.println(address);
	    		 if(s_id== null || s_id.trim().length() == 0 || state== null
							|| state.trim().length() == 0 ||address== null || address.trim().length() == 0 ) {
	    			 JOptionPane.showMessageDialog(null,
								"Please Enter all the Fields");
	    		 }
	    		 else{
	    		try
	    		{
	    			Connection connection=DriverManager.getConnection(url,user,password);
	    				System.out.println("Connected to database");
	    				String query="Update address set s_id='"+textField.getText()+"',state='"+textField_1.getText()+"',address='"+textField_2.getText()+"'where s_id='"+textField.getText()+"'  ";
	    				PreparedStatement preparedStmt =connection.prepareStatement(query);
	    				preparedStmt.execute();
	    				
	    				System.out.println("Updated Successfully");
	    				//Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Updated Successfully");
						connection.close();
						
	    		}
	    		catch(Exception e3)
	    		{
	    			e3.printStackTrace();
	    		}
	    			 
	    			 textField.setText(null);
					 textField_1.setText(null);
					 textField_2.setText(null);
			 
	    	 }
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(721, 361, 138, 36);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADDRESS");
		lblNewLabel_2.setBounds(45, 249, 261, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_3 = new JLabel("STATE");
		lblNewLabel_3.setBounds(45, 149, 261, 40);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("SOLDIER ID");
		lblNewLabel.setBounds(45, 61, 261, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		textField_2 = new JTextField();
		textField_2.setBounds(464, 230, 377, 47);
		panel.add(textField_2);
		textField_2.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(464, 146, 377, 47);
		panel.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(464, 62, 377, 40);
		panel.add(textField);
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(1221, 140, 142, 31);
		frmAddress.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(735, 139, 119, 36);
		frmAddress.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ADDRESS.main(new String[] {});
			}
		});
		//Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(27, 25, 89, 36);
		frmAddress.getContentPane().add(btnNewButton_1_3);
	}
}