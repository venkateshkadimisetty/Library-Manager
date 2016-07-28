package libManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libManager.bean.IssueBookBean;

public class IssueDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public IssueDAO(){
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
	public int insertDB(IssueBookBean ibb){
		String query="INSERT INTO `test`.`book_lends` (`s_id`, `b_id`, `issue_date`, `due_date`) VALUES ('"+ibb.memId+"', '"+ibb.bookId+"', '"+ibb.issueDate+"', '"+ibb.dueDate+"')";
		int res=0;
		try {
			res=stmt.executeUpdate(query);
			stmt.executeUpdate("UPDATE `test`.`members` SET `no_of_books`=`no_of_books`+'1' WHERE `s_id`='"+ibb.memId+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
