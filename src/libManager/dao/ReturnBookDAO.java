package libManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libManager.bean.ReturnBookBean;
import libManager.factory.DateFactory;

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
				rbb.setsId(rs.getInt(1));
				rbb.setbId(rs.getInt(2));
				rbb.setIssueDate(rs.getDate(3));
				rbb.setDueDate(rs.getDate(4));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rbb;  
		}
	
	public int deleteBookLendDetails(ReturnBookBean rbb){
		int res=0;
		try{
			res=stmt.executeUpdate("DELETE FROM `test`.`book_lends` WHERE `b_id`='"+rbb.getbId()+"'");
			stmt.executeUpdate("UPDATE `test`.`members` SET `total_fine`=`total_fine`+'"+rbb.getFine()+"' WHERE `s_id`='"+rbb.getsId()+"'");
			stmt.executeUpdate("UPDATE `test`.`members` SET `no_of_books`=`no_of_books`-'1' WHERE `s_id`='"+rbb.getsId()+"'");
			stmt.executeUpdate("insert into test.book_len_log values('"+rbb.getsId()+"','"+rbb.getbId()+"','"+DateFactory.utilToSqlDate(rbb.getIssueDate())+"','"+DateFactory.utilToSqlDate(rbb.getDueDate())+"','"+DateFactory.utilToSqlDate(rbb.getSubDate())+"','"+rbb.getFine()+"')");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

}
