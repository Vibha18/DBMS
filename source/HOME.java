import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class HOME extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME frame = new HOME();
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
	
	public HOME() {
		frame=new JFrame();
		setBackground(new Color(230, 230, 250));
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 740);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARMY MANAGEMENT");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setBounds(477, 20, 469, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 20, 80, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PERSONAL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PERSONAL.main(new String[] {});
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1.setBounds(244, 200, 284, 43);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("ADDRESS ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ADDRESS.main(new String[] {});
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_2.setBounds(786, 200,284, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("FAMILY");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FAMILY.main(new String[] {});
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_3.setBounds(532, 330,284, 43);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("WEAPON");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WEAPON.main(new String[] {});
			}
		});
		btnNewButton_4.setBounds(58, 317, 284, 43);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("AWARDS");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AWARDS.main(new String[] {});
			}
		});
		
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_5.setBounds(1079, 317, 284, 43);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("REGIMENT");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				REGIMENT.main(new String[] {});
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_6.setBounds(244, 456,284, 43);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("TRAINING");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TRAINING.main(new String[] {});
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_7.setBounds(818, 456, 284, 43);
		contentPane.add(btnNewButton_7);
	}

}