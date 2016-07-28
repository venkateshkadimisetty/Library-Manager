package libManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libManager.bean.ReturnBookBean;

public class ReturnBookDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public ReturnBookDAO(){
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
	public ReturnBookBean getBookLendDetails(int b_id){
		ReturnBookBean rbb=null;
		try {
			rs=stmt.executeQuery("select * from book_lends where b_id="+b_id);
			rbb=new ReturnBookBean();
			while(rs.next())  {
				rbb.sId=rs.getInt(1);
				rbb.bId=rs.getInt(2);
				rbb.issueDate=rs.getString(3);
				rbb.dueDate=rs.getString(4);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rbb;  
		}
	
	public int deleteBookLendDetails(ReturnBookBean rbb){
		int res=0;
		try{
			res=stmt.executeUpdate("DELETE FROM `test`.`book_lends` WHERE `b_id`='"+rbb.bId+"'");
			stmt.executeUpdate("UPDATE `test`.`members` SET `total_fine`=`total_fine`+'"+rbb.fine+"' WHERE `s_id`='"+rbb.sId+"'");
			stmt.executeUpdate("UPDATE `test`.`members` SET `no_of_books`=`no_of_books`-'1' WHERE `s_id`='"+rbb.sId+"'");
			stmt.executeUpdate("insert into test.book_len_log values('"+rbb.sId+"','"+rbb.bId+"','"+rbb.issueDate+"','"+rbb.dueDate+"','"+rbb.subDate+"','"+rbb.fine+"')");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

}
