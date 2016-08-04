package libManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libManager.bean.BookBean;
import libManager.factory.DateFactory;

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
	public void addBook(BookBean bb){
		String query="INSERT INTO `test`.`books` (`b_id`, `b_name`, `author_name`, `aval_date`) VALUES ('"+bb.getbId()+"', '"+bb.getbName()+"', '"+bb.getAuthorName()+"', '"+DateFactory.utilToSqlDate(bb.getAvalDate())+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
