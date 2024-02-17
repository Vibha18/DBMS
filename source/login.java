import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class login extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		frame = new JFrame();
		setBackground(SystemColor.text);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 687);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Image img1 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		//Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		
		//Image img3 = new ImageIcon(this.getClass().getResource("/a2.png")).getImage();
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 1231, 630);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(824, 0, 407, 630);
		panel_1.add(lblNewLabel_3);
		//Image img2 = new ImageIcon(this.getClass().getResource("/armyy2.png")).getImage();
		//lblNewLabel_3.setIcon(new ImageIcon(img2));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 620, 1, 10);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 153, 0));
		panel_3.setBounds(0, 0, 825, 630);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARMY MANAGEMENT ");
		lblNewLabel.setBounds(147, 49, 534, 58);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		
		
		JPanel panel = new JPanel();
		panel.setBounds(140, 158, 541, 289);
		panel_3.add(panel);
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u="ruchitha";
				String u1="siri";
				String u2="sneha";
				String u3="vibha";
				
				String p="ruchitha123";
				String p1="siri123";
				String p2="sneha123";
				String p3="vibha123";
				
				String user=textField_1.getText();
				String pass=passwordField.getText();
				
				if(u.equals(user)  || u1.equals(user) || u2.equals(user) || u3.equals(user))
				{
					if((u.equals(user) && p.equals(pass))  ||(u1.equals(user) && p1.equals(pass))|| (u2.equals(user) && p2.equals(pass))||(u3.equals(user) && p3.equals(pass)) )
					{
						JOptionPane.showMessageDialog(null,"Login Successfully");
						frame.dispose();
						HOME.main(new String[] {});
					}
					else
					{
						JOptionPane.showMessageDialog(null,"invalid password");
						textField_1.setText(null);
						passwordField.setText(null);
						
					}
	
				}
				else
				{
					JOptionPane.showMessageDialog(null,"invalid username");
					passwordField.setText(null);
					textField_1.setText(null);
					
				}
			}
		});
		btnNewButton.setBounds(182, 191, 174, 47);
		//btnNewButton.setIcon(new ImageIcon(img));
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(33, 50, 237, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(33, 110, 174, 24);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 50, 199, 28);
		panel.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(431, 144, 100, 142);
		panel.add(lblNewLabel_4);
		//lblNewLabel_4.setIcon(new ImageIcon(img3));		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField.setBounds(280, 106, 199, 28);
		panel.add(passwordField);
	}
}