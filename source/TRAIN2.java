import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class TRAIN2 extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";
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
					TRAIN2 frame = new TRAIN2();
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
	public TRAIN2() {
		frame = new JFrame();
		setTitle("TRAINING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRAINING ");
		lblNewLabel.setBounds(629, 23, 433, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(341, 211, 753, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(52, 76, 184, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("TYPE");
		lblNewLabel_2.setBounds(52, 147, 184, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_3 = new JLabel("REGIMENT NAME");
		lblNewLabel_3.setBounds(52, 223, 238, 23);
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
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(295, 384, 153, 39);
		panel.add(btnReset);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
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
	    				String query="Update training set so_id='"+textField.getText()+"',type='"+textField_1.getText()+"',r_name='"+textField_2.getText()+"',duration='"+textField_3.getText()+"' where so_id='"+textField.getText()+"' ";
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
		btnUpdate.setBounds(569, 384, 153, 39);
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
		btnNewButton_4.setBounds(1171, 122, 142, 31);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TRAINING.main(new String[] {});
			}
		});
		//Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(43, 36, 83, 31);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(642, 131, 119, 36);
		contentPane.add(btnNewButton_1_2);
	}
}