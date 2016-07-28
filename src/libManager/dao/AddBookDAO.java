package libManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libManager.bean.AddBookBean;

public class AddBookDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public AddBookDAO(){
		try{  
			/*Class.forName("com.mysql.jdbc.Driver");    
			con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/test","test",""); */
			con=DAO.getConnection(); 
			System.out.println(con); 
			stmt=con.createStatement();  
			}catch(Exception e)
				{ 
					System.out.println(e);
				}  
			  
			}
	public void addBook(AddBookBean abb){
		String query="INSERT INTO `test`.`books` (`b_id`, `b_name`, `author_name`, `aval_date`) VALUES ('"+abb.bId+"', '"+abb.bName+"', '"+abb.bAuthor+"', '"+abb.bDate+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
