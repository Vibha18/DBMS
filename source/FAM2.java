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

public class FAM2 extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";

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
					FAM2  frame = new FAM2 ();
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
	public FAM2() {
		frame = new JFrame();
		setTitle("FAMILY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FAMILY ");
		lblNewLabel.setBounds(660, 34, 445, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(310, 229, 856, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(81, 37, 207, 42);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(81, 104, 148, 30);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_3 = new JLabel("RELATIONSHIP");
		lblNewLabel_3.setBounds(81, 176, 194, 30);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_4 = new JLabel("PHN NO");
		lblNewLabel_4.setBounds(81, 249, 201, 30);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField.setColumns(10);
		textField.setBounds(453, 43, 334, 30);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(453, 104, 334, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(453, 176, 334, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(453, 249, 334, 30);
		panel.add(textField_3);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(370, 345, 153, 39);
		panel.add(btnReset);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
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
	    				String query="Update family set sol_id='"+textField.getText()+"',name='"+textField_1.getText()+"',relationship='"+textField_2.getText()+"',ph_no='"+textField_3.getText()+"' where sol_id='"+textField.getText()+"' ";
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
					 textField_3.setText(null);
					 
	    	 }
				
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(658, 345, 153, 39);
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
		btnNewButton_4.setBounds(1222, 133, 142, 31);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FAMILY.main(new String[] {});
			}
		});
		//Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(24, 34, 73, 31);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(628, 142, 119, 36);
		contentPane.add(btnNewButton_1_2);
	}
}