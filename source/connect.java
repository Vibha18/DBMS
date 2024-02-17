import java.sql.*;


public class connect {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
		String url="jdbc:mysql://localhost/army";
		 String user="root";
		 String password="root@123";
		
				try {
					
					Connection con=DriverManager.getConnection(url,user,password);
					 System.out.println("Connected to database");
				} 
				catch (SQLException e) {
					System.out.println("Error");
					e.printStackTrace();
				}
			}
		}
