package libManager.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private static Connection con;
	/*private DAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/test","test",""); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		 } */ 
		
	
	public static Connection getConnection(){
		if(con==null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/test","test",""); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
		
	}

}
