//package images;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class VIEWF {
	
	String url="jdbc:mysql://localhost/army";;
	String user="root";
	String password="root@123";

	private JFrame frame;
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEWF window = new VIEWF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VIEWF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		Object[][] data = new Object[1000][6];
		// headers for the table
		String[] columns = new String[] {"Soldier_id","Name","Relationship","Phone_number"};
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection connection=DriverManager.getConnection(url,user,password);
					System.out.println("Connected to database");
					
					String query="select count(*)" + "from FAMILY";
					Statement stmt  = connection.createStatement();
		            ResultSet rsone1 = stmt.executeQuery(query);
		            
		            int rowCount = 0;
		            while (rsone1.next()) {
						rowCount = rsone1.getInt(1);
						System.out.println("Rowcount is now "+ rowCount);
					}
		            
		            String sql = "select sol_id,name,relationship,ph_no " + "from FAMILY";
					Statement smt  = connection.createStatement();
		           ResultSet rstwo = smt.executeQuery(sql);
		           ResultSetMetaData meta = rstwo.getMetaData();
					int colCount = meta.getColumnCount();
					
					if (rowCount == 0)
						JOptionPane.showMessageDialog(null, "No Results to Display");
					else {
						for (int i = 0; i < rowCount; i++) {
							int k = 1;
							if (rstwo.next()) {
								for (int j = 0; j < colCount; j++) {
									data[i][j] = rstwo.getString(k++);
								}
							}
						}
					}
					connection.close();
		           
				}
				catch(Exception e7) {
					e7.printStackTrace();
				}
				frame.repaint();

				
			}
		});
		//btnView.setFont(new Font("Consolas", Font.PLAIN, 22));
		btnView.setBounds(292, 82, 99, 35);
		frame.getContentPane().add(btnView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 127, 762, 411);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(data,columns);
		//table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
		
		frame.setBounds(100, 100, 1205, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Object[][] data = new Object[1000][4];
		// headers for the table
		//String[] columns = new String[] {"Soldier_id","Name","Relationship","Phone_number"};
	}
}
