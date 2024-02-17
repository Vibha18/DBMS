import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class vvv {
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
					vvv window = new vvv();
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
	public vvv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 1212, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"so_id", "nam", "sol_id"
			}
		));
		Object[][] data = new Object[100][3];
		// headers for the table
		String[] columns = new String[] {"Soldier_id","State","Address"};
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection connection=DriverManager.getConnection(url,user,password);
					System.out.println("Connected to database");
					
					String query="select count(*)" + "from ADDRESS";
					Statement stmt  = connection.createStatement();
		            ResultSet rsone1 = stmt.executeQuery(query);
		            
		            int rowCount = 0;
		            while (rsone1.next()) {
						rowCount = rsone1.getInt(1);
						System.out.println("Rowcount is now "+ rowCount);
					}
		            
		            String sql = "select s_id,state,address " + "from ADDRESS";
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
		
		table.setBounds(10, 41, 394, 502);
		frame.getContentPane().add(table);
		
		JButton view = new JButton("New button");
		view.setBounds(27, 10, 85, 21);
		frame.getContentPane().add(view);
	}
}
